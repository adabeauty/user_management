'use strict';

angular.module('userManagement')
    .controller('promotionNewController', function($scope, $resource, $location, $http){


        log_out_nav_bar();
        is_log_in();

        function is_log_in(){

            $http.get('/web/api/session').success(function(result){

                if(result){
                    $scope.Admin.name = result.name;
                    $scope.logIn = true;
                    $scope.logOut = false;
                }
            });
        }

        $scope.log_out = function(){
            $http.delete('/web/api/session').success(function(result){
                log_out_nav_bar();
            });
        };

        function log_out_nav_bar(){
            $scope.Admin = {};
            $scope.logIn = false;
            $scope.logOut = true;
        }

        var Promotion = $resource("/web/api/v1/promotion/");
        $scope.promotion = {};
        $scope.create = function(){

            var localPromoton = new Promotion($scope.promotion);
            localPromoton.$save().then(function(result){
                $location.path("/new_promotion");
            });
        }
    });