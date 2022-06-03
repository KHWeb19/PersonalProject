<template>
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
</template>

<script>
import {TimeConverter} from '../javascript/timeconverter'

export default{
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

    props: {
        posts: Object
        
    },
    mounted(){
        if (this.posts.content.length)
            TimeConverter.removeMicroseconds(this.posts.content)
    }
}
</script>
