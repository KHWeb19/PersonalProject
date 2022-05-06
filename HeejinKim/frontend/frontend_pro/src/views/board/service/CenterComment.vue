<template>
    <div>
        <center-comment-form 
        :commentList="centerComments" 
        :centerNo="centerNo"
        :centerName="`${this.centerName}`"
        @submit="onSubmit"/>
    </div>
</template>

<script>
import CenterCommentForm from '@/components/board/service/CenterCommentForm.vue'
import { mapActions, mapState } from 'vuex'
import axios from 'axios'
export default {
    data () {
        return {
              centerName: "centerComments"
        }
    },
      props: {
        centerNo: {
            type: String,
            required: true
        }
    },
     
    components: {
        CenterCommentForm
    },
    computed: {
        ...mapState(['centerComments'])
    },
      created () {
        this.fetchCenterCommentsList(this.centerNo)
                .catch(() => {
                    alert('게시물 요청 실패!')
                    this.$router.push()
                })
         
    },
       methods: {
        ...mapActions(['fetchCenterCommentsList']),
        
         onSubmit (payload) {
            const { commentWriter, comment } = payload
            const centerNo = this.centerNo
            axios.post(`http://localhost:7777/centerComments/register/${centerNo}`, { commentWriter, comment })
                    .then(() => {
                        alert('댓글 등록')
                        this.$router.push('/serviceBoard')
                    })
                    .catch(() => {
                        alert('문제 발생!')
                    })
        }
    },
}
</script>