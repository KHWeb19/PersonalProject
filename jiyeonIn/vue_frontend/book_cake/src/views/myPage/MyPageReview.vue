<template>
    <div class="Main">
        <main-page-form></main-page-form>

        <div class="myPage">
            <my-page-review-form :reviewsIdLists="reviewsIdLists" @submit="modifySubmit" ></my-page-review-form>
        </div>

        <footer-form></footer-form>
    </div>
</template>

<script>
import MainPageForm from '@/components/layout/MainPageForm.vue'
import FooterForm from '@/components/layout/FooterForm.vue'
import MyPageReviewForm from '@/components/myPage/MyPageReviewForm.vue'
import { mapState, mapActions } from 'vuex'
import axios from 'axios'

    export default {
        name: 'MyPageReview',
        components:{
            MainPageForm,
            FooterForm,
            MyPageReviewForm
        }
        ,
        props: {
            id: {
                type: String,
                required: true
            }
        },
        data() {
            return {

            }
        },
        computed: {
            ...mapState(['reviewsIdLists'])
        },
        mounted() {
            this.fetchReviewsIdLists(this.id)
        },
        methods: {
            ...mapActions(['fetchReviewsIdLists']),
            modifySubmit(payload) {
                const { dbrAction, modifyContent, modifyRegDate, modifyNo, files2 } = payload

                let formData = new FormData()

                let fileInfo = {
                id: dbrAction,
                content : modifyContent,
                regDate : modifyRegDate,
                reviewNo : modifyNo
                }

                console.log(fileInfo)

                formData.append(
                    "info", new Blob([JSON.stringify(fileInfo)], {type:"application/json"})
                )

                if(files2.length > 0) {
                    for(let idx = 0; idx <1; idx++) {
                        formData.append('fileList', this.files2[idx])
                    }
                }

                axios.put('http://localhost:7777/review/modify', formData)
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

<style scoped>
.Main {
    background: rgb(255, 186, 186);
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