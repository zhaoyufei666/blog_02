$(".button").click(function() {
  activateAnimation($(this).parent(), $(this));

});

function activateAnimation(parent, button) {
  var backgroundcolor = "#99B898";
  if (button.hasClass("cancel")){
    backgroundcolor =  "#E84A5F";
  }
  if (parent.next().length) {
  var next = parent.nextAll();
  var tl = new TimelineMax();
  tl.to(parent, 1, { backgroundColor: backgroundcolor, ease: Power4.easeOut })
    .to(parent, 0.5, {
      x: "-400px",
      ease: Bounce.easeOut
    }).to(next, 1, {  
    y: "+=-68px",
    ease: Bounce.easeOut})
} else {
    var next = parent.nextAll();
  var tl = new TimelineMax();
  tl.to(parent, 1, { backgroundColor: backgroundcolor, ease: Power4.easeOut })
    .to(parent, 0.5, {
      x: "-400px",
      ease: Bounce.easeOut
    })
}
}