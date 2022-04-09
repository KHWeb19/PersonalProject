<template>
    <v-container>
        <header-view></header-view>
        <br>
        <drop-down></drop-down>
           <div align="center">
        <k-1-check-brand-register @submit="onSubmit"/>
    </div>

        </v-container>
</template>
<script>
import K1CheckBrandRegister from '@/components/BrandCheckBoard/K1CheckBrandRegister.vue'
import HeaderView from '@/components/home/headerView.vue'
import DropDown from '@/components/KategoriePage1/DropDown.vue'
//import axios from 'axios'
export default {
    name:'K1CheckBrandRegisterPage',
    components:{ 
    HeaderView,
    DropDown,
    K1CheckBrandRegister
    },
    /* backend작업시 풀예정
     methods: {
        onSubmit (payload) {
            const { title, content, writer, regDate } = payload
            axios.post('http://localhost:7777/vueboard/register', { title, writer, content, regDate })
                    .then(res => {
                        // alert('등록 성공! - ' + res)
                        console.log('게시물 번호 : ' + res.data.boardNo.toString())
                        this.$router.push({
                            name: 'BoardListPage',
                           // params: { boardNo: res.data.boardNo.toString() }
                        })
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        }
    }*/
}
</script>