'use strict';

angular.module('userManagement')
    .controller('logInController', function($scope, $http){

        $scope.administrator = {
            name: 'admin',
            password: '123456'
        };

        $scope.logIn = function(){
            $http.post('/web/api/admins', {name: $scope.administrator.name, password:$scope.administrator.password}).success(function(data){

                console.log(data);
            });
        };

        //
        //var Admin = $resource("/web/api/admins/");
        //$scope.user = {};
        //$scope.create = function(){
        //
        //    var localAdmin = new Admin($scope.administrator);
        //    localAdmin.$save().then(function(data){
        //        console.log(data);
        //    });
        //
        //}
    });