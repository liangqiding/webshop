new Vue({
    el:"#checkout",
        data:{
            address:{},
            newcart:{},
            sumPrices:''
        },
        created:function () {
            this.findaddress();
            this.SelCart();
            this.SumPriceaa();
        },
        methods:{
            //获取商品详细信息
            findaddress:function () {
                var _this = this;
                axios.get('/SelAddress', {
                    params: {
                        uuid: -1
                    }
                })
                    .then(function (value) {
                        _this.address=value.data;
                        console.log();
                    })
                    .catch(function (error) {
                        console.log(error);
                    })

            },
            SelCart:function () {
                var _this = this;
                axios.get('/SelCartOne', {
                    params: {
                        uuid: -1
                    }
                })
                    .then(function (value) {
                        _this.newcart=value.data;
                        console.log();
                    })
                    .catch(function (error) {
                        console.log(error);
                    })

            },
            SumPriceaa:function () {
                var _this = this;
                axios.get('/SumPrice', {
                    params: {
                        uuid: -1
                    }
                })
                    .then(function (value) {
                        _this.sumPrices=value.data;
                        console.log();
                    })
                    .catch(function (error) {
                        console.log(error);
                    })

            },
            //更新地址
            saves:function (id) {
                var name=$("#name").val();
                var phone=$("#phone").val();
                var address=$("#addressA").val();
                var _this = this;
                axios.get('/SaveAddress', {
                    params: {
                        id: id,
                        name:name,
                        phone:phone,
                        address:address,
                    }
                })
                    .then(function (value) {
                        _this.address=value.data;
                        alert(value.data)
                        _this.findaddress();
                    })
                    .catch(function (error) {
                        console.log(error);
                    })
            },

    }
})



// vue1.findAll(66)

