<template>
    <div>
        <qn-a-list-form :qnaBoards="qnaBoards"/>

        <v-btn absolute right plain router-link :to="{ path: 'QnARegisterPage' }">
            <v-icon>mdi-clipboard-edit-outline</v-icon>
        </v-btn>

    </div>
</template>

<script>

import QnAListForm from '@/components/qna/QnAListForm.vue'
import { mapState, mapActions } from 'vuex'


export default {
    name: 'QnAListPage',
    components: {
        QnAListForm
    },
    computed: {
        ...mapState(['qnaBoards'])
    },
    mounted () {
        this.fetchQnABoardList()
    },
    methods: {
        ...mapActions(['fetchQnABoardList'])
    }
}

</script>