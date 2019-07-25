(function ($) {
    "use strict";
    //最新最全最好的Bootstrap模板：http://www.bootstrapmb.com
	$.avia_utilities = $.avia_utilities || {};
	$.avia_utilities.supported = {};
	$.avia_utilities.supports = (function () {
		var div = document.createElement('div'),
			vendors = ['Khtml', 'Ms', 'Moz', 'Webkit', 'O'];
		return function (prop, vendor_overwrite) {
			if (div.style.prop !== undefined) {
				return "";
			}
			if (vendor_overwrite !== undefined) {
				vendors = vendor_overwrite;
			}
			prop = prop.replace(/^[a-z]/, function (val) {
				return val.toUpperCase();
			});

			var len = vendors.length;
			while (len--) {
				if (div.style[vendors[len] + prop] !== undefined) {
					return "-" + vendors[len].toLowerCase() + "-";
				}
			}
			return false;
		};
	}());
	/* Smartresize */
	(function ($, sr) {
		var debounce = function (func, threshold, execAsap) {
			var timeout;
			return function debounced() {
				var obj = this, args = arguments;

				function delayed() {
					if (!execAsap)
						func.apply(obj, args);
					timeout = null;
				}

				if (timeout)
					clearTimeout(timeout);
				else if (execAsap)
					func.apply(obj, args);
				timeout = setTimeout(delayed, threshold || 100);
			}
		}
		// smartresize
		jQuery.fn[sr] = function (fn) {
			return fn ? this.bind('resize', debounce(fn)) : this.trigger(sr);
		};
	})(jQuery, 'smartresize');
})(jQuery);

var custom_js = {
	init            : function () {
		// var navigation_menu = jQuery('.site-header').outerHeight(true);
		jQuery('#preload').delay(100).fadeOut(500, function () {
			jQuery(this).remove();
		});


	},
	mobile_menu     : function () {
		/*Hamburger Button*/
		jQuery('.menu-mobile-effect').on("click", function () {
			jQuery(this).toggleClass("is-active");
			jQuery('.navigation-menu-inner .main-menu').slideToggle(200, 'linear');
		});

		jQuery('.navmenu .menu-item-has-children').append('<span class="zmdi zmdi-chevron-down show-submenu-mobile"></span>');
		jQuery('.navmenu .menu-item-has-children .show-submenu-mobile').on('click touch', function (e) {
			e.preventDefault();
			if (jQuery(this).prev().is(':hidden')) {
				jQuery(this).prev().slideDown(200, 'linear');
				jQuery(this).addClass('toggle-open');
			} else {
				jQuery(this).prev().slideUp(200, 'linear');
				jQuery(this).removeClass('toggle-open');
			}
		});
		/*End Mobile Menu*/
	},
	search          : function () {
		jQuery('.search-toggler').on('click', function (e) {
			jQuery('.search-overlay').addClass("search-show");
		});
		jQuery('.closeicon,.background-overlay').on('click', function (e) {
			jQuery('.search-overlay').removeClass("search-show");
		});
		jQuery(document).keyup(function (e) {
			if (e.keyCode == 27) {
				jQuery('.search-overlay').removeClass("search-show");
			}
		});

	},
	scrollToTop     : function () {
		jQuery(window).scroll(function () {
			if (jQuery(this).scrollTop() > 100) {
				jQuery('.footer__arrow-top').css({bottom: "15px"});
			} else {
				jQuery('.footer__arrow-top').css({bottom: "-100px"});
			}
		});
		jQuery('.footer__arrow-top').on('click', function () {
			jQuery('html, body').animate({scrollTop: '0px'}, 800);
			return false;
		});
	},
	scrolldow       : function () {
		jQuery('.scroll-down').on('click', function (e) {
			e.preventDefault();
			jQuery('html, body').animate(
				{
					scrollTop: $($(this).attr('href')).offset().top
				},
				500, 'linear');
		});
	},
	stickyHeaderInit: function () {
		//Add class for masthead
		var height_header_wrap = jQuery('.navigation-menu').outerHeight();
		var height_topbar = 1;
		if (height_header_wrap > 0) {
			jQuery('.site-header').css({"min-height": height_header_wrap + 'px'});
		}
		var header_area_height = jQuery('.header-area-overlay .header-area').outerHeight();
		if (header_area_height > 0) {
			jQuery('.breadcrumb-section').css({"padding-top": header_area_height + 'px'});
		}
		console.log(jQuery('.topbar-area').outerHeight());
		jQuery(window).scroll(function () {
			if (jQuery(this).scrollTop() > height_topbar) {
				jQuery('.sticky_header .navigation-menu').removeClass('affix-top').addClass('affix');
			} else {
				jQuery('.sticky_header .navigation-menu').removeClass('affix').addClass('affix-top');
			}
		});
	},
	post_gallery    : function () {
		if (jQuery().flexslider) {
			jQuery('.gallery-slider').flexslider({
				slideshow     : true,
				animation     : 'fade',
				pauseOnHover  : true,
				animationSpeed: 400,
				smoothHeight  : true,
				directionNav  : true,
				controlNav    : false,
				prevText      : '',
				nextText      : ''
			});
		}
	},
	our_teams_slider: function () {
		if (jQuery().slick) {
			jQuery(".our-teams").each(function () {
				var $this = jQuery(this),
					slider = $this.find('.our-teams-sliders'),
					$btn_prev = slider.next().find('.es-nav-prev'),
					$btn_next = slider.next().find('.es-nav-next'),
					speed = slider.data('speed');
				slider.slick({
					infinite     : true,
					arrows       : true,
					speed        : 800,
					dots         : true,
					autoplay     : true,
					autoplaySpeed: speed,
					slidesToShow : 1,
					centerMode   : false,
					prevArrow    : $btn_prev,
					nextArrow    : $btn_next,
					responsive   : [
						{
							breakpoint: 992,
							settings  : {}
						},
						{
							breakpoint: 768,
							settings  : {}
						}
					]
				});
			});
			jQuery(".sc-posts-layout_2").each(function () {
				var $this = jQuery(this),
					slider = $this.find('.inner-list-posts'),
					item = slider.data('item'),
					speed = slider.data('speed');
				slider.slick({
					infinite      : true,
					arrows        : false,
					speed         : 800,
					dots          : true,
					autoplay      : true,
					autoplaySpeed : speed,
					slidesToShow  : item,
					slidesToScroll: item,
					centerMode    : false,
					responsive    : [
						{
							breakpoint: 992,
							settings  : {
								slidesToShow  : 3,
								slidesToScroll: 3,
							}
						},
						{
							breakpoint: 768,
							settings  : {
								slidesToShow  : 2,
								slidesToScroll: 2,
							}
						},
						{
							breakpoint: 480,
							settings  : {
								slidesToShow  : 1,
								slidesToScroll: 1,
							}
						}
					]
				});
			});
		}
	},

	quantity_buttons: function () {
		jQuery('div.quantity:not(.buttons_added), td.quantity:not(.buttons_added)').addClass('buttons_added').append('<input type="button" value="+" class="plus modify-qty" />').prepend('<input type="button" value="-" class="minus modify-qty"/>');
		jQuery(document).on("click", ".plus, .minus", function () {
			var a = jQuery(this).closest(".quantity").find(".qty"), t = parseFloat(a.val()),
				l = parseFloat(a.attr("max")), s = parseFloat(a.attr("min")), r = a.attr("step");
			jQuery(this).is(".plus") ? l && (l == t || t > l) ? a.val(l) : a.val(t + parseFloat(r)) : s && (s == t || s > t) ? a.val(s) : t > 0 && a.val(t - parseFloat(r)), a.trigger("change")
		});
	},

	singleSlider      : function () {
		if (jQuery().flexslider) {
			jQuery('#carousel').flexslider({
				animation    : "slide",
				controlNav   : false,
				animationLoop: true,
				slideshow    : true,
				itemWidth    : 145,
				itemMargin   : 20,
				asNavFor     : '#slider',
				smoothHeight : false,
				directionNav : true,
				prevText     : "",
				nextText     : ""
			});
			jQuery('#slider').flexslider({
				animation    : "slide",
				controlNav   : false,
				animationLoop: true,
				slideshow    : true,
				sync         : "#carousel",
				directionNav : false,             //Boolean: Create navigation for previous/next navigation? (true/false)
				start        : function (slider) {
					jQuery('body').removeClass('loading');
				}
			});
		}
	},
	quick_view: function () {
		jQuery('.quick-view').on('click', function () {
			jQuery(".mfp-wrap").css("display", "block");
			jQuery(".mfp-bg").css("display", "block");
		});

		jQuery(".mfp-close").on('click', function () {
			jQuery(".mfp-wrap").css("display", "none");
			jQuery(".mfp-bg").css("display", "none");
		});
	},
	product_quick_view: function () {
		if (jQuery().flexslider) {
			jQuery('#flex-carousel').flexslider({
				animation    : "slide",
				controlNav   : false,
				animationLoop: true,
				slideshow    : true,
				itemWidth    : 110,
				itemMargin   : 20,
				asNavFor     : '#flex-slider',
				smoothHeight : false,
				directionNav : true,
				prevText     : "",
				nextText     : ""
			});
			jQuery('#flex-slider').flexslider({
				animation    : "slide",
				controlNav   : false,
				animationLoop: true,
				slideshow    : true,
				sync         : "#flex-carousel",
				directionNav : false,             //Boolean: Create navigation for previous/next navigation? (true/false)
			});
		}
	},
	generateCarousel  : function () {
		if (jQuery().owlCarousel) {
			jQuery('.sc-testimonials').owlCarousel({
				loop      : true,
				margin    : 10,
				nav       : true,
				responsive: {
					0   : {
						items: 1
					},
					600 : {
						items: 1
					},
					1000: {
						items: 1
					}
				}
			})
		}
		if (jQuery().owlCarousel) {
			jQuery('.owl-carousel').owlCarousel({
				loop      : true,
				margin    : 10,
				nav       : false,
				responsive: {
					0   : {
						items: 1
					},
					600 : {
						items: 2
					},
					1000: {
						items: 4
					}
				}
			})
		}
	},
	couponcheckout    : function () {
		jQuery(".showcoupon").on('click', function () {
			jQuery(".woocommerce-form-coupon").slideToggle();
		});
		jQuery(".showlogin").on('click', function () {
			jQuery(".checkout-login").slideToggle();
		});
		jQuery('.input-radio').on('click', function (e) {
			jQuery(this).parent().toggleClass('active')
		})
		jQuery('.caculate-shipping').on('click', function (e) {
			jQuery(".update-total-cart").slideToggle(400,function () {
				jQuery(".wc-proceed-to-checkout").slideToggle();
			});
		})
		jQuery('.update-total').on('click', function (e) {
			jQuery(".update-total-cart").slideToggle(400,function () {
				jQuery(".wc-proceed-to-checkout").slideToggle();
			});
		})

		jQuery('.prev').on('click', function (e) {
			e.stopImmediatePropagation();
			var btn_group_parent = $(this).closest('.btn-group');
			var number = 0;
			var show_number = btn_group_parent.find('.show-number');
			var a = show_number.text();
			a = parseInt(a);
			if (a > 1) {
				number = a - 1;
			} else {
				number = 1;
			}
			show_number.text(number);

		});

		jQuery('.next').on('click', function (e) {
			e.stopImmediatePropagation();
			var btn_group_parent = $(this).closest('.btn-group');
			var number = 0;
			var show_number = btn_group_parent.find('.show-number');
			var a = show_number.text();
			a = parseInt(a);
			if (a > 0) {
				number = a + 1;
			}
			show_number.text(number);
		});
	},
	revolution_slider : function () {
		jQuery('#rev_slider_1_1').show().revolution({
			sliderType            : "standard",
			sliderLayout          : "auto",
			dottedOverlay         : "none",
			delay                 : 3000,
			navigation            : {
				onHoverStop: "off",
			},
			responsiveLevels      : [1240, 1024, 778, 480],
			visibilityLevels      : [1240, 1024, 778, 480],
			gridwidth             : [1300, 1024, 778, 480],
			gridheight            : [600, 400, 400, 400],
			lazyType              : "none",
			shadow                : 0,
			spinner               : "spinner0",
			stopLoop              : "off",
			stopAfterLoops        : -1,
			stopAtSlide           : -1,
			shuffle               : "off",
			autoHeight            : "off",
			disableProgressBar    : "on",
			hideThumbsOnMobile    : "off",
			hideSliderAtLimit     : 0,
			hideCaptionAtLimit    : 0,
			hideAllCaptionAtLilmit: 0,
			debugMode             : false,
			fallbacks             : {
				simplifyAll           : "off",
				nextSlideOnWindowFocus: "off",
				disableFocusListener  : false,
			}
		});
		jQuery("#rev_slider_3_1").show().revolution({
			sliderType            : "standard",
			sliderLayout          : "auto",
			dottedOverlay         : "none",
			delay                 : 6000,
			navigation            : {
				onHoverStop: "off",
			},
			responsiveLevels      : [1240, 1024, 778, 480],
			visibilityLevels      : [1240, 1024, 778, 480],
			gridwidth             : [1366, 1024, 778, 480],
			gridheight            : [800, 650, 500, 400],
			lazyType              : "none",
			shadow                : 0,
			spinner               : "spinner0",
			stopLoop              : "off",
			stopAfterLoops        : -1,
			stopAtSlide           : -1,
			shuffle               : "off",
			autoHeight            : "off",
			disableProgressBar    : "on",
			hideThumbsOnMobile    : "off",
			hideSliderAtLimit     : 0,
			hideCaptionAtLimit    : 0,
			hideAllCaptionAtLilmit: 0,
			debugMode             : false,
			fallbacks             : {
				simplifyAll           : "off",
				nextSlideOnWindowFocus: "on",
				disableFocusListener  : false,
			}
		});
		jQuery("#rev_slider_4_1").show().revolution({
			sliderType            : "standard",
			sliderLayout          : "auto",
			dottedOverlay         : "none",
			delay                 : 5000,
			navigation            : {
				keyboardNavigation   : "off",
				keyboard_direction   : "horizontal",
				mouseScrollNavigation: "off",
				mouseScrollReverse   : "default",
				onHoverStop          : "off",
				arrows               : {
					style        : "",
					enable       : true,
					hide_onmobile: false,
					hide_onleave : false,
					tmp          : '',
					left         : {
						h_align : "left",
						v_align : "bottom",
						h_offset: 30,
						v_offset: 30
					},
					right        : {
						h_align : "left",
						v_align : "bottom",
						h_offset: 50,
						v_offset: 30
					}
				}
			},
			responsiveLevels      : [1240, 1024, 778, 480],
			visibilityLevels      : [1240, 1024, 778, 480],
			gridwidth             : [1300, 1024, 778, 480],
			gridheight            : [800, 600, 500, 400],
			lazyType              : "none",
			shadow                : 0,
			spinner               : "spinner0",
			stopLoop              : "off",
			stopAfterLoops        : -1,
			stopAtSlide           : -1,
			shuffle               : "off",
			autoHeight            : "off",
			disableProgressBar    : "on",
			hideThumbsOnMobile    : "off",
			hideSliderAtLimit     : 0,
			hideCaptionAtLimit    : 0,
			hideAllCaptionAtLilmit: 0,
			debugMode             : false,
			fallbacks             : {
				simplifyAll           : "off",
				nextSlideOnWindowFocus: "off",
				disableFocusListener  : false,
			}
		});
		jQuery("#rev_slider_2_1").show().revolution({
			sliderType            : "standard",
			sliderLayout          : "auto",
			dottedOverlay         : "none",
			delay                 : 3000,
			navigation            : {
				keyboardNavigation   : "off",
				keyboard_direction   : "horizontal",
				mouseScrollNavigation: "off",
				mouseScrollReverse   : "default",
				onHoverStop          : "off",
				touch                : {
					touchenabled       : "on",
					touchOnDesktop     : "off",
					swipe_threshold    : 75,
					swipe_min_touches  : 50,
					swipe_direction    : "horizontal",
					drag_block_vertical: false
				}
			},
			responsiveLevels      : [1240, 1024, 778, 480],
			visibilityLevels      : [1240, 1024, 778, 480],
			gridwidth             : [1300, 1240, 778, 480],
			gridheight            : [600, 500, 400, 400],
			lazyType              : "smart",
			parallax              : {
				type   : "mouse",
				origo  : "slidercenter",
				speed  : 2000,
				speedbg: 0,
				speedls: 0,
				levels : [2, 3, 4, 5, 6, 7, 12, 16, 10, 50, 47, 48, 49, 50, 51, 55],
			},
			shadow                : 0,
			spinner               : "off",
			stopLoop              : "off",
			stopAfterLoops        : -1,
			stopAtSlide           : -1,
			shuffle               : "off",
			autoHeight            : "off",
			disableProgressBar    : "on",
			hideThumbsOnMobile    : "on",
			hideSliderAtLimit     : 0,
			hideCaptionAtLimit    : 0,
			hideAllCaptionAtLilmit: 0,
			debugMode             : false,
			fallbacks             : {
				simplifyAll           : "off",
				nextSlideOnWindowFocus: "off",
				disableFocusListener  : false,
			}
		});
		jQuery("#rev_slider_5_1").show().revolution({
			sliderType            : "standard",
			sliderLayout          : "auto",
			dottedOverlay         : "none",
			delay                 : 9000,
			navigation            : {
				onHoverStop: "off",
			},
			responsiveLevels      : [1240, 1024, 778, 480],
			visibilityLevels      : [1240, 1024, 778, 480],
			gridwidth             : [1366, 1024, 778, 480],
			gridheight            : [600, 400, 400, 400],
			lazyType              : "none",
			shadow                : 0,
			spinner               : "spinner0",
			stopLoop              : "off",
			stopAfterLoops        : -1,
			stopAtSlide           : -1,
			shuffle               : "off",
			autoHeight            : "off",
			disableProgressBar    : "on",
			hideThumbsOnMobile    : "off",
			hideSliderAtLimit     : 0,
			hideCaptionAtLimit    : 0,
			hideAllCaptionAtLilmit: 0,
			debugMode             : false,
			fallbacks             : {
				simplifyAll           : "off",
				nextSlideOnWindowFocus: "off",
				disableFocusListener  : false,
			}
		});
		jQuery("#rev_slider_6_1").show().revolution({
			sliderType            : "standard",
			sliderLayout          : "auto",
			dottedOverlay         : "none",
			delay                 : 5000,
			navigation            : {
				keyboardNavigation   : "off",
				keyboard_direction   : "horizontal",
				mouseScrollNavigation: "off",
				mouseScrollReverse   : "default",
				onHoverStop          : "off",
				bullets              : {
					enable       : true,
					hide_onmobile: false,
					style        : "hephaistos",
					hide_onleave : false,
					direction    : "horizontal",
					h_align      : "center",
					v_align      : "bottom",
					h_offset     : 0,
					v_offset     : 20,
					space        : 5,
					tmp          : ''
				}
			},
			responsiveLevels      : [1240, 1024, 778, 480],
			visibilityLevels      : [1240, 1024, 778, 480],
			gridwidth             : [1300, 1024, 778, 480],
			gridheight            : [600, 500, 400, 400],
			lazyType              : "none",
			shadow                : 0,
			spinner               : "spinner0",
			stopLoop              : "off",
			stopAfterLoops        : -1,
			stopAtSlide           : -1,
			shuffle               : "off",
			autoHeight            : "off",
			disableProgressBar    : "on",
			hideThumbsOnMobile    : "off",
			hideSliderAtLimit     : 0,
			hideCaptionAtLimit    : 0,
			hideAllCaptionAtLilmit: 0,
			debugMode             : false,
			fallbacks             : {
				simplifyAll           : "off",
				nextSlideOnWindowFocus: "off",
				disableFocusListener  : false,
			}
		});
	}
}

jQuery(document).ready(function ($) {
	custom_js.init();
	custom_js.mobile_menu();
	custom_js.revolution_slider();
	custom_js.scrollToTop();
	custom_js.stickyHeaderInit();
	custom_js.post_gallery();
	custom_js.our_teams_slider();
	custom_js.quantity_buttons();
	custom_js.quick_view();
	var quick_view = $('.quick-view');
	quick_view.on('click', function (e) {
		custom_js.product_quick_view();
	});
	custom_js.singleSlider();
	custom_js.couponcheckout();
	custom_js.generateCarousel();
	custom_js.scrolldow();
});

jQuery(window).resize(function () {
	custom_js.stickyHeaderInit();
});

// Set the date we're counting down to
var countDownDate = new Date(Date.parse(new Date()) + 26 * 24 * 60 * 60 * 1000);

// Update the count down every 1 second
var x = setInterval(function () {

	// Get todays date and time
	var now = new Date().getTime();

	// Find the distance between now and the count down date
	var distance = countDownDate - now;

	// Time calculations for days, hours, minutes and seconds
	var days = Math.floor(distance / (1000 * 60 * 60 * 24));
	var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
	var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
	var seconds = Math.floor((distance % (1000 * 60)) / 1000);


	// Display the result in the element with id="demo"


	var dealday = document.getElementById('dealday');
	if (dealday != null) {
		document.getElementById("dealdays").innerHTML = days;
		document.getElementById("dealhours").innerHTML = hours;
		document.getElementById("dealminutes").innerHTML = minutes;
		document.getElementById("dealseconds").innerHTML = seconds;
		// If the count down is finished, write some text
		if (distance < 0) {
			clearInterval(x);
			document.getElementById("dealday").innerHTML = "EXPIRED";
		}
	}
}, 1000);