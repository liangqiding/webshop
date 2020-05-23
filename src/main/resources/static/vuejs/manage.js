new Vue({
    el:"#manage",
        data:{
            productlist: {
            },
            imglist: []
        },
        created:function () {
            //查找商品
            this.findAll();
        },
        methods:{
        //获取商品信息
        findAll:function () {
            var _this = this;
            axios.get('/SelManPro', {
                params: {
                    id: -1
                }
            })
                .then(function (value) {
                    _this.productlist=value.data;
                })
                .catch(function (error) {
                    console.log(error);
                })

        },
            //获取商品详细信息
            findimg:function (uuid) {
                var _this = this;
                axios.get('/SelImg', {
                    params: {
                        uuid: uuid
                    }
                })
                    .then(function (value) {
                        _this.imglist=value.data;
                        console.log();
                    })
                    .catch(function (error) {
                        console.log(error);
                    })

            },
            //删除确认
            delC:function (c_chapter_id) {
                var _this = this;
                var msg="您真的要删除吗，删除后，改课程下所有子课程都会删除！！！";
                if(confirm(msg)){
                    //执行删除
                    axios.get('/DELCourse', {
                        params: {
                            c_chapter_id: c_chapter_id
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
                }else {
                    return false;
                }
            }
    }
})



// vue1.findAll(66)

