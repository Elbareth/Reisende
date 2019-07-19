# Reisende
Gra którą piszę na moją pracę licencjacką
CREATE TABLE d_user_phone (
    phone_number_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    FOREIGN KEY(phone_number_id) REFERENCES d_phone(phone_id),
    FOREIGN KEY(user_id) REFERENCES d_user(id)
);
package pl.softsystem.demo.web.assembler

import org.springframework.stereotype.Component
import pl.softsystem.demo.modules.user.User
import pl.softsystem.demo.web.dto.UserDto

@Component
class UserAssembler(private val phoneAssembler: PhoneAssembler) {
    fun toDto(user: User): UserDto {
        return UserDto(user.name, user.age,user.address, phoneAssembler.toDto(user.phone).toMutableList(), user.id)
    }

    fun toDto(lista: List<User>): List<UserDto> {
        return lista.map { toDto(it) }
    }

    fun createEntity(dto: UserDto): User {
        val user: User = User(dto.name, dto.age,dto.address, phoneAssembler.createEntity(dto.phone).toMutableList(), dto.id)
        if (dto.phone.isNotEmpty()) {
            user.setPhones(phoneAssembler.createEntity(dto.phone))
        }
        return user
    }

    fun updateEntity(user: User, userDto: UserDto) {
        user.name = userDto.name
        user.age = userDto.age
        phoneAssembler.updateEntity(user, userDto.phone)
    }

}
import org.springframework.transaction.annotation.Transactional
import pl.softsystem.demo.web.assembler.UserAssembler
import pl.softsystem.demo.web.dto.UserDto
import javax.persistence.EntityNotFoundException

@Service
@EntityScan("pl.softsystem.demo.*")
class UserService(private val userRepository: UserRepository, private val userAssembler: UserAssembler) {

    fun create(userDto: UserDto): UserDto {
        return userAssembler.toDto(userRepository.save(userAssembler.createEntity(userDto)))
    }

    fun delete(id: Long) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id)
        }
        throw EntityNotFoundException("User entity not found")
    }

    fun selectOrThrow(id: Long): UserDto {
        val selectedUser = userRepository.findById(id)
        if (selectedUser.isPresent) {
            return userAssembler.toDto(selectedUser.get())
        }
        throw EntityNotFoundException("User entity not found")
    }

    @Transactional
    fun update(id: Long, userDto: UserDto): UserDto {
        val entity = userRepository.getOne(id)
        userAssembler.updateEntity(entity, userDto)
        return userAssembler.toDto(entity)
    }

    fun isEmpty() : Boolean{
        if(userRepository.count() < 1) return true
        return false
    }

    fun deleteAll(){
        userRepository.deleteAll()
    }
    fun finaAll():List<UserDto>{
        return userAssembler.toDto(userRepository.findAll())
    }
}
