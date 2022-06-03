<template>
    <v-container v-if="comments.content" class="the-container">
        <p class="the-title">Total Comments: {{comments.totalElements}}</p>
        <div v-for="(comment, index) in comments.content" :key="index" class="the-container">
            <div class="the-container__author">{{comment.author}}</div>
            <div class="the-container__regdate">{{comment.regdate}}</div>
            <div class="the-container__content">{{comment.content}}
                <button class="mx-2" @click="deleteComments(comment.id)"><font-awesome-icon icon="fa-solid fa-delete-left" /></button></div>  
        </div>
    </v-container>
</template>

<script>
import {mapActions, mapState} from 'vuex'
import {TimeConverter} from '../../javascript/timeconverter'
import axios from 'axios'

export default
{
    
    computed:{
        ...mapState(['comments'])
    },
    methods:{
        ...mapActions(['list_comments']),
        deleteComments(no){
            axios.get(`/comments/validate/${no}`)
            .then((res) => {
                if (res.data){
                    axios.delete('/comments/delete', {params: {no: no}})
                    .then(window.location.reload())
                }
                else {
                    alert("Only the author can delete comment")
                }           
            })

            //axios.delete('/comments/delete',{params: {no: no}})
            //.then(window.location.reload())
            //.catch(() => console.log("Failed to delete comment"))
        }
    },

    watch:{
        '$route.query': {
            immediate: true,
            handler(newVal){
                this.list_comments({params: {no: this.$route.params.no, page: newVal.page-1, size: newVal.size}})
            }
        }
    },
    beforeUpdate(){
        TimeConverter.toDatesHoursFormat(this.comments.content)
    }


}
</script>

<style scoped>
    .the-container{
        margin: 20px 0 10px 0;
        padding: 10px;
        box-shadow: 0 3px 10px rgb(0 0 0 / 0.2);
    }

    .the-title{
        font-size: 24px;
        font-weight: bold;
    }

    .the-container__author{
        font-size: 20px;
        margin: 4px;
    }

    .the-container__regdate{
        font-size: 14px;
        margin: 4px;
    }

    .the-container__content{
        word-wrap: break-word;
        margin: 4px;
        font-size: 18px;
    }

</style>
