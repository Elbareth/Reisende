<body>
    <div id="loginInUse" class="modal show" role="dialog">
      <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" onClick="$('#loginInUse').removeClass('modal show').addClass('modal close')" class="close" data-dismiss="modal">&times;</button>
            <h4 class="modal-title">Ten login jest juz uzywany</h4>
          </div>
          <div class="modal-body">
            <p>Ten login jest juz uzywany. Wybierz inny</p>
          </div>
          <div class="modal-footer">
            <button type="button" onClick="$('#loginNiePoprawny').removeClass('modal show').addClass('modal close')" class="btn btn-default" data-dismiss="modal">Zamknij</button>
          </div>
        </div>

      </div>
    </div>
</body>