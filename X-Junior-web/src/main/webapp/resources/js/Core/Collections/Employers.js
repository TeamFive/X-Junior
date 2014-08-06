/**
 * Created by Administrator on 28.07.2014.
 */
define(["Collections/Base", "Models/Employer"], function(Base, Employer){
   return Base.extend({
       model: Employer,
       url: "/curator",
       constructor: function(){
           if (this.constructor._instance) {
               return this.constructor._instance;
           } else {
               Base.prototype.constructor.apply(this, arguments);
               this.constructor._instance = this;
           }
       },
       fetch: function(){
           return $.Deferred().resolve();
       },
       /*
       function get employers from server
        */
       getEmployers: function(){

       }
   });
});