<template>
    <div>
        <booking-board-cocoment-form :bookingNo="bookingNo" :boardComments="boardComments" @submit="onSubmit2"/>
        <booking-board-comment-form :bookingNo="bookingNo" :boardComments="boardComments" @submit="onSubmit"/>
    </div>
</template>

<script>
import BookingBoardCommentForm from '../../components/boardPage/BookingBoardCommentForm.vue'
import axios from 'axios'
import { mapState, mapActions } from 'vuex'
import BookingBoardCocomentForm from '../../components/boardPage/BookingBoardCocomentForm.vue'

    export default {
        name: 'BookingBoardComment',
        data () {
            return {
                checkId: (window.localStorage.getItem('id')),
                comments: '',
                id:'',
                boardComment: this.boardComments,
                commentNo:''
            }
        }, 
        props: {
            bookingNo: {
                type: String,
                required: true
            }
        },
        components: { 
            BookingBoardCommentForm,
            BookingBoardCocomentForm 
        },
        computed: {
            ...mapState(['boardComments'])
        },
        mounted() {
            this.fetchBoardComments(this.bookingNo)
        },
        methods: {
            ...mapActions(['fetchBoardComments']),
            onSubmit (payload) {
                const { id, comments, files1 } = payload
                
                let formData = new FormData()

                let fileInfo = {
                    id : id,
                    comments: comments
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
                const bookingNo = this.bookingNo
                axios.post(`http://localhost:7777/boardComment/register/${bookingNo}`, formData)
                        .then(res => {
                            alert('처리결과 :' +res.data)
                            this.$router.go()
                        })
                        .catch(() => {
                            alert('문제발생')
                        })
            },
            onSubmit2 (payload) {
                const { parentNo, checkCommentNo, id, comments, files1 } = payload
                
                let formData = new FormData()

                let fileInfo = {
                    parentNo: parentNo,
                    commentNo: checkCommentNo,
                    id : id,
                    comments: comments
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
                const bookingNo = this.bookingNo
                axios.post(`http://localhost:7777/boardComment/register/Cocoment/${bookingNo}`, formData)
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

</style>