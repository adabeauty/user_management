angular.module('userManagement')
    .controller('UsersNewController', function ($scope, $resource, $location, $http) {

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

        var User = $resource("/web/api/v1/users/");
        $scope.user = {};
        $scope.create = function(){

            var localUser = new User($scope.user);
            localUser.$save().then(function(result){
                $location.path("/");
            });

        }
    });