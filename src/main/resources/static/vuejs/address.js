new Vue({
    el:"#address",
        data:{

            address:{
            },

        },
        created:function () {
            this.findAll();
            // this.findimg();
        },
        methods:{
        findAll:function () {
            var _this = this;
            axios.get('/SelAddress', {
                params: {
                    p_id: -1
                }
            })
                .then(function (value) {
                    _this.address=value.data;
                })
                .catch(function (error) {
                    console.log(error);
                })
        },
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
                    _this.findAll();
                })
                .catch(function (error) {
                    console.log(error);
                })
        },

    }
})



// vue1.findAll(66)

