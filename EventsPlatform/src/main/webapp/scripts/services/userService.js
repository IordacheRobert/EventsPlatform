app.service('userService',['$http','$q','$location',function($http,$q,$location){
    var user={};
    user.authenticationState=false;
    user.loginState=-1;

    this.login=function(email,password){

        var defer = $q.defer()

        $http({
        method: 'POST',
        url: '/EventsPlatform/webapi/users/login',
        headers:{
            "email":email,
            "password":password
        }
      }).then(function successCallback(response) {
          user.value=response.data;
          user.authenticationState=true;
          user.loginState=1;
          $location.path('/profile');
          defer.resolve();
        }, function errorCallback(response) {
          user.loginState=0;
          defer.resolve();
        });

         return defer.promise
    }

    this.getUser=function(){
        return user;
    }

    this.getAuthenticationState=function () {
      return user.authenticationState;
    }

    this.getLoginState=function(){
      return user.loginState;
    }

}]);
