<template>
    <div>
        <notice-list-form :noticeBoards="noticeBoards"/>

        <v-btn v-if="this.userInfo.id === 'admin'" absolute right plain router-link :to="{ name: 'NoticeRegisterPage' }">
            <v-icon>mdi-clipboard-edit-outline</v-icon>
        </v-btn>
    </div>
</template>

<script>

import NoticeListForm from '@/components/notice/NoticeListForm.vue'
import { mapState, mapActions } from 'vuex'


export default {
    name: 'NoticeListPage',
    components: {
        NoticeListForm
    },
    computed: {
        ...mapState(['noticeBoards','userInfo'])
    },
    mounted () {
        this.fetchNoticeBoardList()
    },
    methods: {
        ...mapActions(['fetchNoticeBoardList'])
    }
}

</script>