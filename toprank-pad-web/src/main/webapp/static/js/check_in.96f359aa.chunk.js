webpackJsonp([16],{653:function(e,t,n){"use strict";function r(e){return e&&e.__esModule?e:{default:e}}function o(e,t){if(!(e instanceof t))throw new TypeError("Cannot call a class as a function")}function c(e,t){if(!e)throw new ReferenceError("this hasn't been initialised - super() hasn't been called");return!t||"object"!=typeof t&&"function"!=typeof t?e:t}function a(e,t){if("function"!=typeof t&&null!==t)throw new TypeError("Super expression must either be null or a function, not "+typeof t);e.prototype=Object.create(t&&t.prototype,{constructor:{value:e,enumerable:!1,writable:!0,configurable:!0}}),t&&(Object.setPrototypeOf?Object.setPrototypeOf(e,t):e.__proto__=t)}Object.defineProperty(t,"__esModule",{value:!0});var i,l,u=function(){function e(e,t){for(var n=0;n<t.length;n++){var r=t[n];r.enumerable=r.enumerable||!1,r.configurable=!0,"value"in r&&(r.writable=!0),Object.defineProperty(e,r.key,r)}}return function(t,n,r){return n&&e(t.prototype,n),r&&e(t,r),t}}(),p=n(1),s=r(p),d=n(16),f=n(4),h=r(f);n(1037);var k=(i=(0,d.inject)("checkInStore"),i(l=(0,d.observer)(l=function(e){function t(e){o(this,t);var n=c(this,(t.__proto__||Object.getPrototypeOf(t)).call(this,e));return n.state={current:0},n}return a(t,e),u(t,[{key:"componentDidMount",value:function(){var e=this.props.checkInStore,t=this.state.current;document.onkeydown=function(n){13===n.which&&(0===t?e.checkInClick():e.checkOutClick())}}},{key:"render",value:function(){var e=this;this.props.checkInStore;return s.default.createElement("div",{className:"card-input"},s.default.createElement("div",{className:"card-btns"},s.default.createElement("div",{className:(0,h.default)({select:0===this.state.current}),onClick:function(){e.setState({current:0})}},"签到"),s.default.createElement("div",{className:(0,h.default)({select:1===this.state.current}),onClick:function(){e.setState({current:1})}},"签退")),s.default.createElement("div",{className:"card-content"},s.default.createElement("div",{className:"content"},s.default.createElement("span",null,"请刷卡"),s.default.createElement("input",{type:"text",value:this.props.checkInStore.cardCode,onChange:function(t){t.target.value.length<=30&&e.props.checkInStore.cardOnchange(t.target.value)}})),s.default.createElement("div",{className:"btns",onClick:function(){e.props.handClick&&e.props.handClick()}},"手工签到")))}}]),t}(s.default.Component))||l)||l);t.default=k},654:function(e,t,n){"use strict";function r(e){return e&&e.__esModule?e:{default:e}}function o(e,t){if(!(e instanceof t))throw new TypeError("Cannot call a class as a function")}function c(e,t){if(!e)throw new ReferenceError("this hasn't been initialised - super() hasn't been called");return!t||"object"!=typeof t&&"function"!=typeof t?e:t}function a(e,t){if("function"!=typeof t&&null!==t)throw new TypeError("Super expression must either be null or a function, not "+typeof t);e.prototype=Object.create(t&&t.prototype,{constructor:{value:e,enumerable:!1,writable:!0,configurable:!0}}),t&&(Object.setPrototypeOf?Object.setPrototypeOf(e,t):e.__proto__=t)}Object.defineProperty(t,"__esModule",{value:!0});var i,l,u=function(){function e(e,t){for(var n=0;n<t.length;n++){var r=t[n];r.enumerable=r.enumerable||!1,r.configurable=!0,"value"in r&&(r.writable=!0),Object.defineProperty(e,r.key,r)}}return function(t,n,r){return n&&e(t.prototype,n),r&&e(t,r),t}}(),p=n(1),s=r(p),d=n(16);n(1039);var f=(i=(0,d.inject)("checkInStore"),i(l=(0,d.observer)(l=function(e){function t(e){o(this,t);var n=c(this,(t.__proto__||Object.getPrototypeOf(t)).call(this,e));return n.handleClick=function(e){n.props.checkInStore.handleClick(e.target.innerHTML)},n.handleBack=function(){n.props.checkInStore.handleBack()},n.handleClear=function(){n.props.checkInStore.handleClear()},n.cardClick=function(){n.props.cardClick&&n.props.cardClick()},n.inClick=function(){n.props.inClick&&n.props.inClick()},n.outClick=function(){n.props.outClick&&n.props.outClick()},n.props.checkInStore.cardCode="",n}return a(t,e),u(t,[{key:"render",value:function(){return s.default.createElement("div",{className:"hand-input"},s.default.createElement("div",{className:"hand-header"},s.default.createElement("span",null,"请输入工号"),s.default.createElement("input",{type:"text",value:this.props.checkInStore.cardCode,readOnly:!0})),s.default.createElement("ul",null,s.default.createElement("li",{className:"number",onClick:this.handleClick},"1"),s.default.createElement("li",{className:"number",onClick:this.handleClick},"2"),s.default.createElement("li",{className:"number",onClick:this.handleClick},"3"),s.default.createElement("li",{className:"back iconfont icon-order_btn_back",onClick:this.handleBack}),s.default.createElement("li",{className:"number",onClick:this.handleClick},"4"),s.default.createElement("li",{className:"number",onClick:this.handleClick},"5"),s.default.createElement("li",{className:"number",onClick:this.handleClick},"6"),s.default.createElement("li",{className:"clear-all",onClick:this.handleClear},"清空"),s.default.createElement("li",{className:"number",onClick:this.handleClick},"7"),s.default.createElement("li",{className:"number",onClick:this.handleClick},"8"),s.default.createElement("li",{className:"number",onClick:this.handleClick},"9"),s.default.createElement("li",{className:"cancle",onClick:this.inClick},"签到"),s.default.createElement("li",{className:"zero",onClick:this.handleClick},"0"),s.default.createElement("li",{className:"use-hand",onClick:this.cardClick},"刷卡"),s.default.createElement("li",{className:"confirm",onClick:this.outClick},"签退")))}}]),t}(s.default.Component))||l)||l);t.default=f},655:function(e,t,n){"use strict";function r(e){return e&&e.__esModule?e:{default:e}}function o(e,t){if(!(e instanceof t))throw new TypeError("Cannot call a class as a function")}function c(e,t){if(!e)throw new ReferenceError("this hasn't been initialised - super() hasn't been called");return!t||"object"!=typeof t&&"function"!=typeof t?e:t}function a(e,t){if("function"!=typeof t&&null!==t)throw new TypeError("Super expression must either be null or a function, not "+typeof t);e.prototype=Object.create(t&&t.prototype,{constructor:{value:e,enumerable:!1,writable:!0,configurable:!0}}),t&&(Object.setPrototypeOf?Object.setPrototypeOf(e,t):e.__proto__=t)}Object.defineProperty(t,"__esModule",{value:!0});var i,l,u=(n(52),n(51)),p=r(u),s=function(){function e(e,t){for(var n=0;n<t.length;n++){var r=t[n];r.enumerable=r.enumerable||!1,r.configurable=!0,"value"in r&&(r.writable=!0),Object.defineProperty(e,r.key,r)}}return function(t,n,r){return n&&e(t.prototype,n),r&&e(t,r),t}}(),d=n(1),f=r(d),h=n(16);n(1038);var k=n(653),b=r(k),m=n(654),x=r(m);p.default.config({top:300});var g=(i=(0,h.inject)("checkInStore"),i(l=(0,h.observer)(l=function(e){function t(e){o(this,t);var n=c(this,(t.__proto__||Object.getPrototypeOf(t)).call(this,e));return n.state={isCardPopup:!1},n}return a(t,e),s(t,[{key:"render",value:function(){var e=this,t=this.props.checkInStore,n=void 0;return n=this.state.isCardPopup?f.default.createElement(b.default,{handClick:function(){e.setState({isCardPopup:!1}),e.props.checkInStore.cardCode=""}}):f.default.createElement(x.default,{inClick:function(){t.checkInClick()},outClick:function(){t.checkOutClick()},cardClick:function(){e.setState({isCardPopup:!0}),e.props.checkInStore.cardCode=""}}),f.default.createElement("div",{className:"check-in"},f.default.createElement("div",{className:"check-in-header"},f.default.createElement("i",{className:"iconfont icon-order_btn_back",onClick:function(){e.context.router.goBack()}}),"签到"),f.default.createElement("div",{className:"check-in-content"},n))}}]),t}(f.default.Component))||l)||l);g.wrappedComponent.contextTypes={router:f.default.PropTypes.object.isRequired},t.default=g},764:function(e,t,n){t=e.exports=n(2)(),t.push([e.id,".card-input{width:600px;height:364px;position:absolute;top:50%;left:50%;margin-left:-300px;margin-top:-182px}.card-input .card-btns{width:100%;height:44px;display:-webkit-box;display:-ms-flexbox;display:flex;-webkit-box-pack:justify;-ms-flex-pack:justify;justify-content:space-between}.card-input .card-btns div{cursor:pointer;width:280px;height:44px;background:#fff;border:1px solid #8e729d;border-radius:4px;text-align:center;line-height:44px;font-size:16px;color:#8e729d}.card-input .card-btns .select{background:#8e729d;color:#fff}.card-input .card-content{margin-top:30px;width:600px;height:280px;border-radius:4px}.card-input .card-content .content{height:235px;background:#fff;padding-top:100px;padding-left:20px}.card-input .card-content .content span{font-size:22px;color:#666}.card-input .card-content .content input{margin-left:20px;background:#fff;border:1px solid #cacaca;border-radius:4px;outline:none;width:400px;height:54px;font-size:20px;padding-left:10px}.card-input .card-content .btns{width:100%;height:45px;background:#8e729d;font-size:18px;color:#fff;line-height:45px;border-radius:0 0 4px 4px;text-align:center;cursor:pointer}",""])},765:function(e,t,n){t=e.exports=n(2)(),t.push([e.id,".check-in{display:relative}.check-in .check-in-header{width:100%;height:46px;background:#825f9f;position:relative;font-size:20px;text-align:center;line-height:46px;color:#fff}.check-in .check-in-header i{position:absolute;left:30px;line-height:20px;top:13px;font-size:18px;color:#fff;cursor:pointer}.check-in .check-in-content{position:fixed;top:46px;left:0;right:0;bottom:0;width:100%;background:#eee}",""])},766:function(e,t,n){t=e.exports=n(2)(),t.push([e.id,".hand-input{width:510px;height:510px;position:absolute;top:50%;left:50%;margin-left:-255px;margin-top:-255px}.hand-input .hand-header{height:135px;display:-webkit-box;display:-ms-flexbox;display:flex;background:#fff;padding-left:10px}.hand-input .hand-header span{font-size:22px;color:#666;margin-top:50px}.hand-input .hand-header input{background:#fff;border:1px solid #cacaca;border-radius:4px;width:340px;height:54px;font-size:20px;color:#666;padding-left:10px;margin-top:40px;margin-left:10px;outline:none}.hand-input ul{margin-top:10px;height:362px;background:#fff}.hand-input li{width:25%;float:left;height:91px;box-sizing:border-box;border-top:1px solid #ccc;border-right:1px solid #ccc;font-size:40px;color:#666;text-align:center;line-height:91px;cursor:pointer}.hand-input .zero{width:50%}.hand-input .cancle{font-size:24px;color:#fff;background:#8e729d}.hand-input .clear-all,.hand-input .use-hand{font-size:24px}.hand-input .confirm{font-size:24px;color:#fff;background:#f15454}",""])},1037:function(e,t,n){var r=n(764);"string"==typeof r&&(r=[[e.id,r,""]]);n(3)(r,{});r.locals&&(e.exports=r.locals)},1038:function(e,t,n){var r=n(765);"string"==typeof r&&(r=[[e.id,r,""]]);n(3)(r,{});r.locals&&(e.exports=r.locals)},1039:function(e,t,n){var r=n(766);"string"==typeof r&&(r=[[e.id,r,""]]);n(3)(r,{});r.locals&&(e.exports=r.locals)}});
//# sourceMappingURL=check_in.96f359aa.chunk.js.map