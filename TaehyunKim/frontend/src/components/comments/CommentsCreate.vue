<template>
    <v-container class="the-container">
        <p class="the-title">Post Comment</p>
        <div class="the-flex">
            <textarea class="the-textarea" v-model=content></textarea>
            <v-btn @click="createComment" class="primary">Post</v-btn>
        </div>
        <div class="d-flex justify-content-end">
        </div>
    </v-container>

</template>

<script>
import axios from 'axios'

export default{
    data()
    {
        return {
            content: ''
        }
    },
    methods:{
        createComment(){
            const {content} = this
            const payload =  {content}
            axios.post(`comments/create/${this.$route.params.no}`, payload)
            .then(window.location.reload())
        }
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

    .the-textarea{
        width: 90%; 
        min-height: 100px;
        border: 1px solid;
        resize: none;
    }

    .the-flex{
        display: flex;
        justify-content: space-around;
        align-items: center;
    }

</style>
