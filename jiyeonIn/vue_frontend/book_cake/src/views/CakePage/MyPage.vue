<template>
    <div class="Main">
        <main-page-form></main-page-form>

        <div class="myPage">
            <my-page-form v-if="memberInfo" :memberInfo="memberInfo" @submit="onSubmit"></my-page-form>
        </div>

        <footer-form></footer-form>
    </div>
</template>

<script>
import MainPageForm from '@/components/layout/MainPageForm.vue'
import FooterForm from '@/components/layout/FooterForm.vue'
import MyPageForm from '@/components/myPage/MyPageForm.vue'
import { mapState, mapActions } from 'vuex'
import axios from 'axios'

    export default {
        name: 'MyPage',
        components: {
            MainPageForm,
            FooterForm,
            MyPageForm
        },
        data(){
            return{
                userId:'',
            }
        },
        props: {
            id: {
                type: String,
                required: true
            }
        },
        computed:{
            ...mapState(['memberInfo'])
        },
        created () {
            this.fetchMemberInfo(this.id)
                    .catch(() => {
                        alert('my페이지 확인 실패!')
                        this.$router.push()
                    })
        },
        methods: {
            ...mapActions(['fetchMemberInfo']),
            onSubmit(payload) {
                const { userName, password } = payload
                
                this.userId = this.id
                axios.put(`http://localhost:7777/Member/${this.userId}`, { userName, password })
            }
        }
    }
</script>

<style scoped>

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