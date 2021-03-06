/**
 * Created by Administrator on 06.08.2014.
 */
define(["Collections/Base", "Models/Manager"], function(Base, Manager){
    return Base.extend({
        model: Manager,
        url: "/hr",
        constructor: function(){
            if (this.constructor._instance) {
                return this.constructor._instance;
            } else {
                Base.prototype.constructor.apply(this, arguments);
                this.constructor._instance = this;
            }
        }
    });
});