<template>
    <div class="Main">
        <main-page-form></main-page-form>

        <div class="wrap">
            <h3>후기 작성하기</h3>
            <br>
            <review-page-form :reviews="reviews" @submit="onSubmit"/>
        </div>

        <footer-form></footer-form>
    </div>
</template>

<script>
import MainPageForm from '@/components/layout/MainPageForm.vue'
import FooterForm from '@/components/layout/FooterForm.vue'
import ReviewPageForm from '@/components/mainPage/ReviewPageForm.vue'
import axios from 'axios'
import { mapState, mapActions } from 'vuex'

    export default {
        name: 'ReviewPage',
        data () {
            return {
                id: (window.localStorage.getItem('id')),
                content: ''
            }
        },
        components: {
            MainPageForm,
            FooterForm,
            ReviewPageForm
        },
        computed: {
            ...mapState(['reviews'])
        },
        mounted() {
            this.fetchReviews()
        },
        methods: {
            ...mapActions(['fetchReviews']),
            onSubmit(payload) {
                const {id, content, files1} = payload

                let formData = new FormData()


                let fileInfo = {
                    id : id,
                    content : content
                }

                formData.append(
                    "info", new Blob([JSON.stringify(fileInfo)], {type:"application/json"})
                )

                if(files1 != null) {
                    for(let idx = 0; idx <1; idx++) {
                        formData.append('fileList', files1[idx])
                    }
                }

                console.log(fileInfo)
                axios.post('http://localhost:7777/review/register', formData)
                        .then(res => {
                            alert('처리결과 :' +res.data)
                            this.$router.go()
                        })
                        .catch(() => {
                            alert('문제발생')
                        })
            }
        }
    }
                
</script>

<style scoped>

.Main {
    background: rgb(255, 186, 186);
}


.wrap {
    margin:2% 10% 3% 10%;
    padding: 15px;
    border: 3px solid rgb(243, 180, 180);
}
</style>