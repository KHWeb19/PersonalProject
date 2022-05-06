<template>
  
    <v-container>
        <v-row>
            <center-read-form v-if="center" :center="center"/>            
        </v-row>
        <v-row>
            <center-comment-form @submit="onSubmit" :centerComments="centerComments" :centerNo="centerNo" />
                       
        </v-row>
    </v-container>
</template>

<script>
import CenterReadForm from '@/components/board/service/CenterReadForm.vue' 
import CenterCommentForm from '@/components/board/service/CenterCommentForm.vue'
import axios from 'axios'
import { mapActions, mapState } from 'vuex'
export default {
    name:'CenterRead',
   
    props: {
        centerNo: {
            type: String,
            required: true
        },
         
    },
    
    
    computed: {
        ...mapState(['center','centerComments'])
    },
    components: {  
       CenterReadForm,
       CenterCommentForm
    },
    created () {
        this.fetchCenter(this.centerNo)
                .catch(() => {
                    alert('게시물 요청 실패!')
                    console.log(this.centerNo)
                    this.$router.push()
                })
    },
    
    methods: {
        ...mapActions(['fetchCenter','fetchCenterCommentsList']),
        onSubmit (payload) {
            const { comment, commentWriter } = payload
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
    mounted() {
        this.fetchCenterCommentsList(this.centerNo)
    },
}
</script>

<style scoped>
.title{
    margin-top:5%;
    margin-bottom: 5%;
}
</style>