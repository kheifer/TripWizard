function onClick (event) {
            $(this).parent().hide();
            $(this).parent().next().show();
            event.preventDefault();
          };

          $(".btn-info").click(onClick);