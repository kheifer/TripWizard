$("#search-icon").click(function(){
 search-box.val('');
});

var $r = $('input[type="range"]');
var $ruler = $('<div class="rangeslider__ruler" />');

// Initialize slider
$r.rangeslider({
  polyfill: false,
  onInit: function() {
    $ruler[0].innerHTML = getRulerRange(this.min, this.max, this.step);
    this.$range.prepend($ruler);}
});

function getRulerRange(min, max, step) {
  var range = '';
  var i = 0;
  
  while (i <= max) {
    range += i + ' ';
    i = i + step;
  }
  return range;
}
//modal
$('.btn[data-toggle=modal]').on('click', function(){
  var $btn = $(this);
  var currentDialog = $btn.closest('.modal-dialog'),
  targetDialog = $($btn.attr('data-target'));;
  if (!currentDialog.length)
    return;
  targetDialog.data('previous-dialog', currentDialog);
  currentDialog.addClass('aside');
  var stackedDialogCount = $('.modal.in .modal-dialog.aside').length;
  if (stackedDialogCount <= 5){
    currentDialog.addClass('aside-' + stackedDialogCount);
  }
});

$('.modal').on('hide.bs.modal', function(){
  var $dialog = $(this);
  var previousDialog = $dialog.data('previous-dialog');
  if (previousDialog){
    previousDialog.removeClass('aside');
    $dialog.data('previous-dialog', undefined);
  }
});