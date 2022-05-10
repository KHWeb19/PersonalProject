<template>
    <v-container>
        <div class="the-section">
            <p class="the-section__the-title">All Posts</p>
        </div>
        <div v-if="posts.content.length">
            <v-data-table
            :headers="headers"
            :items="posts.content"
            hide-default-footer>
            <template v-slot:[`item.title`]="{item}">
                <router-link style="text-decoration: none; color: inherit;"
                :to="`/readpost/${item.id}`">{{item.title}}
            </router-link>
            </template>
            </v-data-table>
            
            <the-pagination :posts="posts" />
            <v-btn to="/createpost" class="primary">Create a new post</v-btn>
        </div>
        <not-found v-else/>
    </v-container>
</template>

<script>
import { mapState, mapActions} from 'vuex'
import ThePagination from '../../components/ThePagination.vue'
import NotFound from '../NotFound.vue'
import {TimeConverter} from '../../javascript/timeconverter'


export default {
    components:{
        ThePagination,
        NotFound
    },
    data(){
        return {
            headers: [
                    {text: 'No', value: 'id', width: '10%'},
                    {text: 'Title', value: 'title', width: '60%'},
                    {text: 'Author', value: 'author', width: '10%'},
                    {text: 'Date', value: 'regdate', width: '10%'},
                    {text: 'Views', value: 'hits', width: '10%'}
            ]
        }
    },
 
    computed:{
        ...mapState(['posts'])
    },
    methods:{
        ...mapActions(['list_posts'])
    },

    watch:{
        
        '$route.query': {
            immediate: true,
            handler(newVal){
                this.list_posts({params: {page: newVal.page-1, size: newVal.size}})
            }
        }
    },
    beforeUpdate(){
        TimeConverter.isCreatedToday(this.posts.content)
    }
    
}
</script>

<style scoped>

    .the-section{
        margin: 4px;
        padding: 4px;
    }

    .the-section__the-title{
    font-size: 30px;
    font-weight: bold;
    }

</style>