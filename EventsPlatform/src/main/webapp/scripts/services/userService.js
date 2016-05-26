app.service('userService',['$http','$q','$location',function($http,$q,$location){
    var user={};
    user.authenticationState=false;
    user.loginState=-1;
    user.published_events={};
    
    
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
    
    
    this.get_my_events=function(){

        var defer = $q.defer()

        $http({
        method: 'GET',
        url: '/EventsPlatform/webapi/users/'+user.value.id+'/events'
      }).then(function successCallback(response) {
          user.published_events=response.data;
          defer.resolve(response.data);
        }, function errorCallback(response) {
          defer.resolve();
        });

         return defer.promise
    }
    
    this.test=function(){
        console.log("test");
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
    
    this.getPublischedEvents=function(){
      return user.published_events;
    }
    

}]);
