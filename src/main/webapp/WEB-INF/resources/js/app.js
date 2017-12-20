/**
 * Created by grgbibek22 on 12/20/2017.
 */
var app = angular
        .module("myModule",[])
        .controller("myController",function ($scope,$http){
           $http.get('/hall/getHall')
               .then(function (response) {
                   $scope.hallList = response.data;

               });
        });