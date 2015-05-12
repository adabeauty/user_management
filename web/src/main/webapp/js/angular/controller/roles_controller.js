'use strict';

angular.module('userManagement')
    .controller('roleController', function($scope, $http){

        var current_user;
        log_out_nav_bar();
        is_log_in();

        function is_log_in(){

            $http.get('/web/api/session').success(function(result){
                current_user = result;
                if(result){
                    $scope.Admin.name = result.user.name;
                    $scope.logIn = true;
                    $scope.logOut = false;
                }
            });
        }
    });