new Vue({
    el:"#love",
        data:{
            products:{
            },
        },
        created:function () {
            this.findAll();
        },
        methods:{
        findAll:function () {
            var _this = this;
            axios.get('/SelLovePro', {
                params: {
                    p_id: -1
                }
            })
                .then(function (value) {
                    _this.products=value.data;
                })
                .catch(function (error) {
                    console.log(error);
                })
        },
            //删除
            //删除确认
            dellove:function (p_id) {
                     var _this=this;
                    axios.get('/DelLoveById', {
                        params: {
                            p_id: p_id
                        }
                    })
                        .then(function (value) {
                            alert(value.data)
                            //刷新页面
                            _this.findAll();
                            console.log(value);
                        })
                        .catch(function (error) {
                            console.log(error);
                        })
            },
            // 截取当前数据到小数点后两位
            numFilter(value) {
                const realVal = parseFloat(value).toFixed(2);
                return realVal;
            },
    }
})



// vue1.findAll(66)

