<template>
    <v-container>
        <v-data-table :headers="headers" :items="posts">
            <template v-slot:[`item.title`] ="{item}">
                <router-link :to="{name: 'readpost', params: {no: item.id}}">
                    {{item.title}}
                </router-link>
            </template>
        </v-data-table>      
        <v-btn to="/createpost">Create a new post</v-btn>
    </v-container>
</template>

<script>
import { mapState, mapActions} from 'vuex'

export default {
    data(){
        return{
            headers: [
                {
                    text: 'Post_No',
                    align: 'start',
                    sortable: false,
                    value: 'id',
                    width: '10%'
                },
                {text: 'Title', value: 'title', width: '40%'},
                {text: 'Author', value: 'author', width: '10%'},
                {text: 'Content', value: 'content', width: '10%'}
            ]
        }
    },
    computed:{
        ...mapState(['posts'])
    },
    methods:{
        ...mapActions(['list_posts'])
    },
    mounted(){
        this.list_posts()
    }
}
</script>
