<template>
    <v-container>
        <div v-if="posts.content.length">
            <ul>
                <li v-for="(item, index) in posts.content" :key="index">
                    ID: {{item.id}}
                    <router-link :to="`/readpost/${item.id}`">{{item.title}}</router-link>
                </li>
            </ul>
            
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

export default {
    components:{
        ThePagination,
        NotFound
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
    }
    
}
</script>
