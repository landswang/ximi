webpackJsonp([30],{1002:function(t,e,a){"use strict";Object.defineProperty(e,"__esModule",{value:!0}),e.default={data:function(){var t=this;return{outLoanTab:{outLoanHeader:[{type:"index",title:"序号",width:"80px",align:"center"},{title:"贷款编号",key:"loanId",align:"center",render:function(t,e){return t("router-link",{props:{to:{name:"loandetail",params:{loanId:e.row.loanId}}}},e.row.loanId)}},{title:"贷款产品",key:"eProduct",align:"center"},{title:"业务城市",key:"city",align:"center"},{title:"客户姓名",key:"name",align:"center"},{title:"贷款金额",key:"loanMoney",align:"center",render:function(e,a){return"null"==a.row.repaymentSchedule?e("span","-"):e("span",t.fmoney(a.row.repaymentSchedule.loanAmount))}},{title:"期数",key:"periods",align:"center"},{title:"还款方式",key:"repayWay",align:"center"},{title:"利率（%）",key:"rate",align:"center",render:function(t,e){return t("span",e.row.rate+"%")}},{title:"放款日期",key:"finalTransferDate",align:"center",render:function(t,e){return t("span",new Date(e.row.finalTransferDate).Format("yyyy-MM-dd"))}},{title:"结清日期",key:"clearDate",align:"center",render:function(t,e){return"null"==e.row.repaymentSchedule?t("span","-"):t("span",e.row.repaymentSchedule.clearDate)}},{title:"累计逾期天数",key:"allOverdueDays",align:"center",render:function(t,e){return"null"==e.row.repaymentSchedule?t("span","-"):t("span",e.row.repaymentSchedule.allOverdueDays)}}],outLoanList:[],dateRange:[],totalPage:10,searchParams:{loanId:"",aBaseName:"",startTime:"",endTime:"",currentPage:1,pageSize:10}},tab:"outLoan"}},created:function(){this.loadList()},methods:{pageChange:function(t){var e=this;e.outLoanTab.searchParams.currentPage!=t&&(e.outLoanTab.searchParams.currentPage=t,e.loadList())},pageSizeChange:function(t){var e=this;e.outLoanTab.searchParams.pageSize!=t&&(e.outLoanTab.searchParams.pageSize=t,e.loadList())},loadList:function(){var t=this;t.$Message.config({top:200,duration:2}),clearTimeout(e),t.$Message.destroy();var e=setTimeout(function(){t.$Message.loading({content:"数据请求中...",duration:0})},500);this.$http.post("AfterLoan/ClearCreditCustomer",t.outLoanTab.searchParams).then(function(a){var n=a.data;clearTimeout(e),t.$Message.destroy(),1==n.code?(t.$Message.success({content:n.msg}),n.data.list&&(t.outLoanTab.totalPage=n.data.count,t.outLoanTab.searchParams.currentPage=n.data.currentPage,t.outLoanTab.searchParams.pageSize=n.data.pageSize,t.outLoanTab.outLoanList=n.data.list)):t.$Message.error(n.msg)}).catch(function(a){clearTimeout(e),t.$Message.destroy(),t.$Message.error({content:a})})},dateChange:function(t){var e=this;_.includes(t,void 0)?(e.outLoanTab.searchParams.startTime="",e.outLoanTab.searchParams.endTime=""):(e.outLoanTab.searchParams.startTime=t[0],e.outLoanTab.searchParams.endTime=t[1])},searchoutLoan:function(){var t=this;t.outLoanTab.searchParams.currentPage=1,t.outLoanTab.searchParams.pageSize=10,t.loadList()},refresh:function(){this.loadList()},clearAll:function(){this.outLoanTab.dateRange=[],this.outLoanTab.searchParams.loanId="",this.outLoanTab.searchParams.aBaseName="",this.outLoanTab.searchParams.startTime="",this.outLoanTab.searchParams.endTime="",this.outLoanTab.searchParams.currentPage=1,this.outLoanTab.searchParams.pageSize=10}}}},1051:function(t,e,a){e=t.exports=a(470)(!0),e.push([t.i,".tab{padding-top:15px}.ivu-tabs-tab{font-size:16px}.page{padding-top:50px;display:-webkit-box;display:-ms-flexbox;display:flex;-webkit-box-pack:end;-ms-flex-pack:end;justify-content:flex-end;-webkit-box-orient:horizontal;-webkit-box-direction:normal;-ms-flex-direction:row;flex-direction:row;padding-bottom:50px}.layout-content .extra-btn{color:#20abff;font-size:14px}.layout-content .ivu-input-group-prepend{background-color:#20abff;border-color:#20abff;width:80px}.yellow-color .ivu-input-group-prepend{background-color:#f0b320;border-color:#f0b320;width:80px}.input-title{color:#fff;font-size:14px}.search-box{-ms-flex-direction:row;flex-direction:row;-ms-flex-pack:distribute;justify-content:space-around;-ms-flex-align:center;padding-top:14px;-ms-flex-wrap:wrap;flex-wrap:wrap}.search-box,.search-item{display:-webkit-box;display:-ms-flexbox;display:flex;-webkit-box-orient:horizontal;-webkit-box-direction:normal;-webkit-box-align:center;align-items:center;padding-bottom:15px}.search-item{-webkit-box-flex:1;-ms-flex:1;flex:1;-ms-flex-direction:row;flex-direction:row;-webkit-box-pack:start;-ms-flex-pack:start;justify-content:flex-start;-ms-flex-align:center;margin-right:10px}.item-title{width:80px;height:36px;font-size:14px;line-height:36px;text-align:center;color:#fff;border-top-left-radius:4px;border-bottom-left-radius:4px}.color-yellow{background-color:#f0b320}.color-red{background-color:#ff7043}.color-green{background-color:#28b779}.search{width:100px;margin-right:10px}.ivu-select-selection,.search-item .ivu-input{border-top-left-radius:0;border-bottom-left-radius:0}","",{version:3,sources:["E:/资方系统/ejie_ecrs/webApp/src/pages/afterloan/outloan.vue"],names:[],mappings:"AACA,KACC,gBAAkB,CAClB,AACD,cACC,cAAgB,CAChB,AACD,MACC,iBAAkB,AAClB,oBAAqB,AACrB,oBAAqB,AACrB,aAAc,AACd,qBAAsB,AAClB,kBAAmB,AACf,yBAA0B,AAClC,8BAA+B,AAC/B,6BAA8B,AAC1B,uBAAwB,AACpB,mBAAoB,AAC5B,mBAAqB,CACrB,AACD,2BACC,cAAe,AACf,cAAgB,CAChB,AACD,yCACC,yBAA0B,AAC1B,qBAAsB,AACtB,UAAY,CACZ,AACD,uCACC,yBAA0B,AAC1B,qBAAsB,AACtB,UAAY,CACZ,AACD,aACC,WAAY,AACZ,cAAgB,CAChB,AACD,YAMK,uBAAwB,AACpB,mBAAoB,AAC5B,yBAA0B,AACtB,6BAA8B,AAE9B,sBAAuB,AAE3B,iBAAkB,AAElB,mBAAoB,AAChB,cAAgB,CACpB,AACD,yBAjBC,oBAAqB,AACrB,oBAAqB,AACrB,aAAc,AACd,8BAA+B,AAC/B,6BAA8B,AAK9B,yBAA0B,AAElB,mBAAoB,AAE5B,mBAAqB,CAuBrB,AAnBD,aACC,mBAAoB,AAChB,WAAY,AACR,OAAQ,AAMZ,uBAAwB,AACpB,mBAAoB,AAC5B,uBAAwB,AACpB,oBAAqB,AACjB,2BAA4B,AAEhC,sBAAuB,AAG3B,iBAAmB,CACnB,AACD,YACC,WAAY,AACZ,YAAa,AACb,eAAgB,AAChB,iBAAkB,AAClB,kBAAmB,AACnB,WAAY,AACZ,2BAA4B,AAC5B,6BAA+B,CAC/B,AACD,cACC,wBAA0B,CAC1B,AACD,WACC,wBAA0B,CAC1B,AACD,aACC,wBAA0B,CAC1B,AACD,QACC,YAAa,AACb,iBAAmB,CACnB,AAKD,8CACC,yBAA4B,AAC5B,2BAA+B,CAC/B",file:"outloan.vue",sourcesContent:["\n.tab {\n\tpadding-top: 15px;\n}\n.ivu-tabs-tab {\n\tfont-size: 16px;\n}\n.page {\n\tpadding-top: 50px;\n\tdisplay: -webkit-box;\n\tdisplay: -ms-flexbox;\n\tdisplay: flex;\n\t-webkit-box-pack: end;\n\t    -ms-flex-pack: end;\n\t        justify-content: flex-end;\n\t-webkit-box-orient: horizontal;\n\t-webkit-box-direction: normal;\n\t    -ms-flex-direction: row;\n\t        flex-direction: row;\n\tpadding-bottom: 50px;\n}\n.layout-content .extra-btn {\n\tcolor: #20abff;\n\tfont-size: 14px;\n}\n.layout-content .ivu-input-group-prepend {\n\tbackground-color: #20abff;\n\tborder-color: #20abff;\n\twidth: 80px;\n}\n.yellow-color .ivu-input-group-prepend {\n\tbackground-color: #f0b320;\n\tborder-color: #f0b320;\n\twidth: 80px;\n}\n.input-title {\n\tcolor: #fff;\n\tfont-size: 14px;\n}\n.search-box {\n\tdisplay: -webkit-box;\n\tdisplay: -ms-flexbox;\n\tdisplay: flex;\n\t-webkit-box-orient: horizontal;\n\t-webkit-box-direction: normal;\n\t    -ms-flex-direction: row;\n\t        flex-direction: row;\n\t-ms-flex-pack: distribute;\n\t    justify-content: space-around;\n\t-webkit-box-align: center;\n\t    -ms-flex-align: center;\n\t        align-items: center;\n\tpadding-top: 14px;\n\tpadding-bottom: 15px;\n\t-ms-flex-wrap: wrap;\n\t    flex-wrap: wrap;\n}\n.search-item {\n\t-webkit-box-flex: 1;\n\t    -ms-flex: 1;\n\t        flex: 1;\n\tdisplay: -webkit-box;\n\tdisplay: -ms-flexbox;\n\tdisplay: flex;\n\t-webkit-box-orient: horizontal;\n\t-webkit-box-direction: normal;\n\t    -ms-flex-direction: row;\n\t        flex-direction: row;\n\t-webkit-box-pack: start;\n\t    -ms-flex-pack: start;\n\t        justify-content: flex-start;\n\t-webkit-box-align: center;\n\t    -ms-flex-align: center;\n\t        align-items: center;\n\tpadding-bottom: 15px;\n\tmargin-right: 10px;\n}\n.item-title {\n\twidth: 80px;\n\theight: 36px;\n\tfont-size: 14px;\n\tline-height: 36px;\n\ttext-align: center;\n\tcolor: #fff;\n\tborder-top-left-radius: 4px;\n\tborder-bottom-left-radius: 4px;\n}\n.color-yellow {\n\tbackground-color: #f0b320;\n}\n.color-red {\n\tbackground-color: #ff7043;\n}\n.color-green {\n\tbackground-color: #28b779;\n}\n.search {\n\twidth: 100px;\n\tmargin-right: 10px;\n}\n.ivu-select-selection {\n\tborder-top-left-radius: 0px;\n\tborder-bottom-left-radius: 0px;\n}\n.search-item .ivu-input {\n\tborder-top-left-radius: 0px;\n\tborder-bottom-left-radius: 0px;\n}\n"],sourceRoot:""}])},1085:function(t,e,a){var n=a(1051);"string"==typeof n&&(n=[[t.i,n,""]]),n.locals&&(t.exports=n.locals);a(471)("f1b28496",n,!0)},1120:function(t,e){t.exports={render:function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("Tabs",{staticClass:"tab",model:{value:t.tab,callback:function(e){t.tab=e},expression:"tab"}},[a("Tab-pane",{staticClass:"tab-item",attrs:{label:"清贷客户",name:"outLoan"}},[a("div",{staticClass:"search-box",on:{keyup:function(e){if(!("button"in e)&&t._k(e.keyCode,"enter",13))return null;t.searchoutLoan(e)}}},[a("div",{staticClass:"search-item"},[a("Input",{staticStyle:{width:"260px"},attrs:{size:"large",placeholder:"请输入贷款编号"},model:{value:t.outLoanTab.searchParams.loanId,callback:function(e){t.outLoanTab.searchParams.loanId=e},expression:"outLoanTab.searchParams.loanId"}},[a("span",{staticClass:"input-title",attrs:{slot:"prepend"},slot:"prepend"},[t._v("贷款编号")])])],1),t._v(" "),a("div",{staticClass:"search-item yellow-color"},[a("Input",{staticStyle:{width:"260px"},attrs:{size:"large",placeholder:"请输入客户姓名"},model:{value:t.outLoanTab.searchParams.aBaseName,callback:function(e){t.outLoanTab.searchParams.aBaseName=e},expression:"outLoanTab.searchParams.aBaseName"}},[a("span",{staticClass:"input-title",attrs:{slot:"prepend"},slot:"prepend"},[t._v("客户姓名")])])],1),t._v(" "),a("div",{staticClass:"search-item"},[a("div",{staticClass:"item-title color-green"},[t._v("放款日期")]),t._v(" "),a("Date-picker",{staticStyle:{width:"352px"},attrs:{size:"large",type:"daterange",editable:!1,placement:"bottom-end",format:"yyyy-MM-dd",placeholder:"选择放款日期范围--年/月/日"},on:{"on-change":t.dateChange},model:{value:t.outLoanTab.dateRange,callback:function(e){t.outLoanTab.dateRange=e},expression:"outLoanTab.dateRange"}})],1),t._v(" "),a("div",{staticClass:"search-item"},[a("i-button",{staticClass:"search",attrs:{type:"primary",size:"large"},on:{click:t.searchoutLoan}},[t._v("查询")]),t._v(" "),a("i-button",{staticClass:"search",attrs:{type:"success",size:"large"},on:{click:t.clearAll}},[t._v("清空")])],1)]),t._v(" "),a("Table",{attrs:{size:"large",columns:t.outLoanTab.outLoanHeader,data:t.outLoanTab.outLoanList}}),t._v(" "),a("div",{staticClass:"page"},[a("Page",{attrs:{placement:"top",total:t.outLoanTab.totalPage,current:t.outLoanTab.searchParams.currentPage,"page-size":t.outLoanTab.searchParams.pageSize,"page-size-opts":[10,20,30,40],"show-elevator":"","show-sizer":"","show-total":""},on:{"on-change":t.pageChange,"on-page-size-change":t.pageSizeChange}})],1)],1),t._v(" "),a("i-button",{staticClass:"extra-btn",attrs:{slot:"extra",type:"text",icon:"ios-loop-strong"},on:{click:t.refresh},slot:"extra"},[t._v("刷新")])],1)},staticRenderFns:[]}},474:function(t,e,a){function n(t){a(1085)}var o=a(47)(a(1002),a(1120),n,null,null);t.exports=o.exports}});
//# sourceMappingURL=30.6dddd9140f2795215f55.js.map