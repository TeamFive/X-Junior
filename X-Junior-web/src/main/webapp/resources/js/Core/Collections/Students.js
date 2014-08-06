/**
 * Created by Administrator on 04.08.2014.
 */
define(["Collections/Base", "Models/Student"], function(Collection, Student){
    return Collection.extend({
        model: Student,
        url: "/student"
    });
});