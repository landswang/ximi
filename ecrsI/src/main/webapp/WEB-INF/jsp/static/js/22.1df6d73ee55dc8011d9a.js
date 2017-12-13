webpackJsonp([22],{1028:function(e,t,o){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var r=function(e,t,o){/^[a-z0-9_-]{3,16}$/.exec(t)?o():o(new Error("用户名应由3至16位字母或数字组成"))},a=function(e,t,o){/^[a-z0-9_-]{6,20}$/.exec(t)?o():o(new Error("密码应由6至20位字母或数字组成"))};t.default={data:function(){return{formItem:{accountName:"",password:"",userName:"",roleName:"",roleId:"",roleComment:""},ruleValidate:{accountName:[{required:!0,message:"用户名不能为空",trigger:"blur"},{required:!0,trigger:"blur",validator:r}],password:[{required:!0,message:"密码不能为空",trigger:"blur"},{required:!0,trigger:"blur",validator:a}],userName:[{required:!0,message:"使用人不能为空",trigger:"blur"}],roleId:[{type:"number",required:!0,message:"请选择角色",trigger:"change"}]},roleList:[]}},created:function(){this.loadRoleName()},methods:{submit:function(e){var t=this,o=this;this.$refs[e].validate(function(e){e?o.$Modal.confirm({title:"确认新建账号",content:"<p>确认新建账号?</p>",loading:!0,onOk:function(){o.$http.post("/user/creatUser",{accountName:o.formItem.accountName,password:o.formItem.password,userName:o.formItem.userName,roleId:o.formItem.roleId}).then(function(e){1==e.data.code?(o.$Modal.remove(),o.$Message.success({content:e.data.msg}),o.$router.push("/system")):o.$Message.error({content:e.data.msg,duration:3,onClose:function(){o.$Modal.remove()}})}).catch(function(e){o.$Message.error({content:e,duration:3,onClose:function(){o.$Modal.remove()}})})}}):t.$Message.error("表单验证失败!")})},selectChange:function(e){var t=this;t.formItem.roleComment=_.result(_.find(t.roleList,{roleId:e}),"roleComment")},loadRoleName:function(){var e=this;this.$http.post("/auth/allRoleName",{}).then(function(t){1==t.data.code?e.roleList=t.data.data:e.$Message.error({content:t.data.msg,duration:3})}).catch(function(t){e.$Message.error({content:t,duration:3})})}}}},1043:function(e,t,o){t=e.exports=o(470)(!0),t.push([e.i,".tab{padding-top:15px}.ivu-tabs-tab{font-size:16px}.layout-content .extra-btn{font-size:14px;color:#20abff}.from-self{padding-top:50px}.block-item{display:-webkit-box;display:-ms-flexbox;display:flex;-webkit-box-orient:horizontal;-webkit-box-direction:normal;-ms-flex-direction:row;flex-direction:row;-webkit-box-pack:justify;-ms-flex-pack:justify;justify-content:space-between;-webkit-box-align:center;-ms-flex-align:center;align-items:center}","",{version:3,sources:["E:/资方系统/ejie_ecrs/webApp/src/pages/system/adduser.vue"],names:[],mappings:"AACA,KACC,gBAAkB,CAClB,AACD,cACC,cAAgB,CAChB,AACD,2BACC,eAAgB,AAChB,aAAe,CACf,AACD,WACC,gBAAkB,CAClB,AACD,YACC,oBAAqB,AACrB,oBAAqB,AACrB,aAAc,AACd,8BAA+B,AAC/B,6BAA8B,AAC1B,uBAAwB,AACpB,mBAAoB,AAC5B,yBAA0B,AACtB,sBAAuB,AACnB,8BAA+B,AACvC,yBAA0B,AACtB,sBAAuB,AACnB,kBAAoB,CAC5B",file:"adduser.vue",sourcesContent:["\n.tab {\n\tpadding-top: 15px;\n}\n.ivu-tabs-tab {\n\tfont-size: 16px;\n}\n.layout-content .extra-btn {\n\tfont-size: 14px;\n\tcolor: #20abff;\n}\n.from-self {\n\tpadding-top: 50px;\n}\n.block-item {\n\tdisplay: -webkit-box;\n\tdisplay: -ms-flexbox;\n\tdisplay: flex;\n\t-webkit-box-orient: horizontal;\n\t-webkit-box-direction: normal;\n\t    -ms-flex-direction: row;\n\t        flex-direction: row;\n\t-webkit-box-pack: justify;\n\t    -ms-flex-pack: justify;\n\t        justify-content: space-between;\n\t-webkit-box-align: center;\n\t    -ms-flex-align: center;\n\t        align-items: center;\n}\n"],sourceRoot:""}])},1077:function(e,t,o){var r=o(1043);"string"==typeof r&&(r=[[e.i,r,""]]),r.locals&&(e.exports=r.locals);o(471)("16bf6f9e",r,!0)},1112:function(e,t){e.exports={render:function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("Tabs",{staticClass:"tab",attrs:{value:"system"}},[o("Tab-pane",{staticClass:"tab-item",attrs:{label:"新建账号",name:"system"}},[o("Form",{ref:"form",staticClass:"from-self",attrs:{model:e.formItem,"label-width":80,rules:e.ruleValidate}},[o("Form-item",{attrs:{label:"账号",prop:"accountName"}},[o("Input",{staticStyle:{width:"400px"},attrs:{placeholder:"字母或字母和数字的组合"},model:{value:e.formItem.accountName,callback:function(t){e.formItem.accountName=t},expression:"formItem.accountName"}})],1),e._v(" "),o("Form-item",{attrs:{label:"密码",prop:"password"}},[o("Input",{staticStyle:{width:"400px"},attrs:{type:"password",maxlength:20,placeholder:"请输入字母和数字密码（不少于6位）"},model:{value:e.formItem.password,callback:function(t){e.formItem.password=t},expression:"formItem.password"}})],1),e._v(" "),o("Form-item",{attrs:{label:"使用人",prop:"userName"}},[o("Input",{staticStyle:{width:"400px"},attrs:{placeholder:"填写使用人名字"},model:{value:e.formItem.userName,callback:function(t){e.formItem.userName=t},expression:"formItem.userName"}})],1),e._v(" "),o("Form-item",{attrs:{label:"角色",prop:"roleName"}},[o("Select",{staticStyle:{width:"400px"},attrs:{placeholder:"请选择角色"},on:{"on-change":e.selectChange},model:{value:e.formItem.roleId,callback:function(t){e.formItem.roleId=t},expression:"formItem.roleId"}},e._l(e.roleList,function(t){return o("Option",{key:t,attrs:{disabled:1e3==t.roleId,value:t.roleId}},[e._v(e._s(t.roleName))])}))],1),e._v(" "),o("Form-item",{attrs:{label:"描述"}},[o("Input",{staticStyle:{width:"400px"},attrs:{disabled:"",placeholder:"角色职责描述"},model:{value:e.formItem.roleComment,callback:function(t){e.formItem.roleComment=t},expression:"formItem.roleComment"}})],1),e._v(" "),o("Form-item",[o("i-button",{attrs:{type:"primary",size:"large"},on:{click:function(t){e.submit("form")}}},[e._v("确定")]),e._v(" "),o("i-button",{staticStyle:{"margin-left":"8px"},attrs:{type:"ghost",size:"large"},on:{click:function(t){e.$router.go(-1)}}},[e._v("取消")])],1)],1)],1),e._v(" "),o("i-button",{staticClass:"extra-btn",attrs:{slot:"extra",type:"text",icon:"ios-undo-outline"},on:{click:function(t){e.$router.go(-1)}},slot:"extra"},[e._v("返回")])],1)},staticRenderFns:[]}},500:function(e,t,o){function r(e){o(1077)}var a=o(47)(o(1028),o(1112),r,null,null);e.exports=a.exports}});
//# sourceMappingURL=22.1df6d73ee55dc8011d9a.js.map