<template>
    <v-container>
        <post-head :post="post" v-if="post"/>
        <div style="height: 500px" v-if="post">
            {{post.content}}
                <div v-for="(file, index) in post.attachments" :key="index">
                    <img v-if="file" :src="require(`../../assets/img/${file.filename}`)" height="100" width="100">
                </div>
                
        </div>
        <hr>
        <div class="d-flex justify-end my-2">
            <span>{{this.$route.params.no}}</span>
            <v-btn color="primary" class="mx-1" :to="{name: 'modifypost', params: $route.params.no}">Modify</v-btn>
            <v-btn color="red white--text">Delete</v-btn>
        </div>
        <hr>
    </v-container>
</template>

<script>
import {mapActions, mapState} from 'vuex'
import PostHead from '../../components/PostHead.vue'
    export default{
    
        components:{
            PostHead
        },
        computed:{
            ...mapState(['post'])
        },
        methods:{
            ...mapActions(['read_post']),
        },
        created(){
            this.read_post(this.$route.params.no)
        }
    }
</script>

<style scoped>
    span{
        font-size: 16px;
        font-weight: bold;
    }
</style>