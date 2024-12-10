let x = angular.module("MyModule", []);

x.controller("MyController", function($scope) {
    $scope.arr = [];

    $scope.add = function() {
        if ($scope.taskname) { 
            let obj = {};
            obj.tname = $scope.taskname;
            $scope.arr.push(obj);
            $scope.taskname = '';  
        }
    };

    $scope.del = function(index) {
        $scope.arr.splice(index, 1);  
    };

    $scope.edit = function(index) {
        $scope.taskname = $scope.arr[index].tname;  
        $scope.del(index);  
    };
});
