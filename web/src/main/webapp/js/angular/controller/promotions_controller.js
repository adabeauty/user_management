'use strict';

angular.module('userManagement')
    .controller('promotionsController', function($scope, $http, $location){

        log_out_nav_bar();
        is_log_in();

        function is_log_in(){

            $http.get('/web/api/session').success(function(result){
                if(result){
                    $scope.Admin.name = result.user.name;
                    $scope.logIn = true;
                    $scope.logOut = false;
                }
            });
        }
        function log_out_nav_bar(){
            $scope.Admin = {};
            $scope.logIn = false;
            $scope.logOut = true;
        }

        $scope.go_to_create_promotion = function(){
            $location.path('new_promotion');
        }
    });