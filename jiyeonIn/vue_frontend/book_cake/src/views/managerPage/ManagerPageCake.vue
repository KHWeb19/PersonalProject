<template>
    <div class="Main">
        <main-page-form></main-page-form>

        <div class="myPage">
           <manager-page-cake-form :cakeLists="cakeLists" @submit="modifySubmit"></manager-page-cake-form> 
        </div>

        <footer-form></footer-form>
    </div>
</template>

<script>
import MainPageForm from '@/components/layout/MainPageForm.vue'
import FooterForm from '@/components/layout/FooterForm.vue'
import ManagerPageCakeForm from '@/components/manager/ManagerPageCakeForm.vue'
import { mapState, mapActions } from 'vuex'
import axios from 'axios'

    export default {
        name: 'ManagerPageCake',
        components: {
            MainPageForm,
            FooterForm,
            ManagerPageCakeForm,
        },
        data(){
            return{

            }
        },
        computed:{
            ...mapState(['cakeLists'])
        },
        mounted() {
            this.fetchCakeLists()
        },
        methods : {
            ...mapActions(['fetchCakeLists']),
            modifySubmit(payload) {
                const { modifyNo, design, size, price, files2 } = payload

                let formData = new FormData()

                let fileInfo = {
                    cakeNo: modifyNo,
                    design: design,
                    size: size,
                    price: price
                }

                formData.append(
                    "info", new Blob([JSON.stringify(fileInfo)], {type:"application/json"})
                )

                if(files2.length > 0) {
                    for(let idx = 0; idx <1; idx++) {
                        formData.append('fileList', this.files2[idx])
                    }
                }

                console.log(fileInfo)
                axios.put('http://localhost:7777/upload/modify', formData)
                        .then(() => {
                            alert('수정되었습니다!')
                            this.$router.go()
                        })
                        .catch(() => {
                            alert('수정 실패!')
                        })
            }
        }
    }
</script>

<style>
.Main {
    background: rgb(255, 186, 186);
}
.MainLogo {
    display: block; margin: 0px auto;
}

.myPage {
    margin:2% 10% 3% 10%;
    padding: 15px;
    border: 3px solid rgb(243, 180, 180);
}

a {
    text-decoration: none;
    font: 300;
}

p {
    color: rgb(0, 0, 0);
    font-weight: 600;
}
hr{ 
    background: #e69191;
    height: 3px;
}
</style>