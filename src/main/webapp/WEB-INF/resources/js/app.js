/**
 * Created by grgbibek22 on 12/20/2017.
 */
var app = angular
            .module("myModule",[])
            /*.controller("myController",function ($scope,$http){

                //getting hall Lilst
               $http.get('/hall/getHallList')
                   .then(function (response) {
                       $scope.hallList = response.data;

                   });*/
            .controller("HallController", function($scope,HallService){

                $scope.AddHall = function(){

                    HallService.AddHallToDB($scope.hall);
                }
            })
            .factory("HallService",['$http',function($http){
                var fac = {};
                fac.AddHallToDB= function(hall){
                    $http.post("/hall/add",hall).success(function(){
                        alert("Added Successfully");
                    })
                };
                return fac;

            }]);