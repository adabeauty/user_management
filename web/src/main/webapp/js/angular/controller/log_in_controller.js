'use strict';

angular.module('userManagement')
    .controller('logInController', function($scope, $http, $location){

        $scope.administrator = {};

        $scope.logIn = function(){
            $http.post('/web/api/admins', {name: $scope.administrator.name, password:$scope.administrator.password}).success(function(result){

                if(JSON.parse(result)){
                    $location.path('/');
                }
            });
        };
    });