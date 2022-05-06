<template>
    <v-container>
        <v-form @submit.prevent="onSubmit">
            <table>
                 <v-row justify="center">
                    
                    <v-col cols>
                        <v-textarea cols="80" rows="3" outlined color="grey" placeholder="Enter your comment" 
                        style="white-space:pre-line" v-model="comment"/>
                    </v-col>
                    
                    <v-btn  type="submit" class="commentBtn" dark>register</v-btn>
                    
                </v-row>

                <v-row  v-for="comments in centerComments" 
                        :key="comments.comNo" justify="center" class="commentArea">
                     <v-col cols="2">
                            {{ comments.commentWriter}}
                        </v-col>
                        <v-col cols="5">
                             {{ comments.comment }}
                        </v-col>
                        <v-col cols="4">
                            <!--{{ comments.regDate}}-->
                            {{ comments.regDate}}
                        </v-col>
                        
                    <template v-if="comments.commentWriter == commentWriter">
                                <v-btn class="comRemoveBtn" @click=comRemove(comments.comNo) small >
                                <v-icon>
                                    mdi-delete
                                </v-icon>
                            </v-btn>
                    </template>
                </v-row>

            </table>
        </v-form>       
    </v-container>
</template>

<script>
import axios from 'axios'

export default {

    name:'CenterCommentForm',

    data () {
        return {
            comment: '',     
            comNo:'',
        }
    },

    created () {
       
        this.commentWriter = this.$store.state.session.userId
    },

    props:{
         centerComments: {
            type: Array,
            required: true
        },
        
         /*
         boardNo: {
            type: String,
            required: true
        },   
      
        boardName:{
            type: String,
            required: true
        }*/
    },
    methods:{
        onSubmit(){
            const { comment,commentWriter } = this
            this.$emit('submit',{comment,commentWriter})
            console.log(comment, commentWriter)
        },
        comRemove (comNo) {
            
            axios.delete(`http://localhost:7777/serviceComments/${comNo}`, {comNo})
                    .then(() => {
                        alert('댓글 삭제.')
                        this.$router.push('/serviceBoard')
                    })
                    .catch(() => {
                        alert('삭제 실패!')
                        console.log(comNo, this.centerNo)
                    })
        },
    }
  
}
</script>
<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Gowun+Dodum&family=Poiret+One&family=Sunflower:wght@300&family=Ubuntu:wght@300&display=swap");
.label{
    font-family: 'Ubuntu', sans-serif; 
    font-size: 15pt;
    margin-right:5%;
    text-align: center;
    padding-top: 25px; 
}
table{
    background-color: #f8f8f8;
    padding: 5% 10% 5% 10%;
    margin-left:auto;
    margin-right:auto;
    width: 855px;
}
.v-text-field, .v-textarea{
    font-family: 'Sunflower', sans-serif;
}
.comRemoveBtn{
    margin-top: 2%;
}
.commentBtn{
      margin-top: 6%;
}
</style>