'use strict';

angular.module("userManagement")
    .controller("itemController", function($scope, $http, $resource){

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

        var Item = $resource("/web/api/v1/items");
        $scope.items = Item.query();
    });