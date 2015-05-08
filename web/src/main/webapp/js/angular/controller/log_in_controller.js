'use strict';

angular.module('userManagement')
    .controller('logInController', function($scope, $http, $location){

        var SUCCESS_MESSAGE = '登录成功';
        var ERROR_MESSAGE = '用户或密码名错误';
        var EXISTED_MESSAGE = '用户已登录';

        $scope.administrator = {};

        $scope.logIn = function(){
            $http.post('/web/api/session', {name: $scope.administrator.name, password:$scope.administrator.password}).success(function(result){

                if(result === SUCCESS_MESSAGE){
                    $location.path('/');
                }
                if(result === ERROR_MESSAGE){
                    console.log(result);
                }
                if(result === EXISTED_MESSAGE){
                    console.log(result);
                }
            });
        };

        $scope.cancel = function(){
            $location.path('/');
        };
    });