<template>
    <div>   
        <board-read v-if=photoBoard :board="photoBoard"
                                    :boardNo="boardNo"
                                    :boardName="`${this.boardName}`"
                                    :listPage="listPage"
                                    :accept="accept" 
                                    :modifyPage="modifyPage"/>
        <!-- 댓글 -->              
        <photo-board-comment :boardNo="this.boardNo"/>
        
    </div>
</template>

<script>

import { mapActions, mapState } from 'vuex'

import BoardRead from '@/components/common/board/BoardRead.vue'
import PhotoBoardComment from '@/views/photoBoard/PhotoBoardComment.vue'

export default {
    name: 'PhotoBoardReadPage',
    props: {
        boardNo: {
            type: String,
            required: true
        }
    },
    data () {
        return {
            listPage: 'PhotoBoardListPage',
            modifyPage: 'PhotoBoardModifyPage',
            boardName: 'photoBoard',
            accept: 'jpg'
        }
    },
    components: {
        BoardRead,
        PhotoBoardComment
    },
    computed: {
        ...mapState(['photoBoard'])
    },
    created () {
        this.fetchPhotoBoard(this.boardNo)
                .catch(() => {
                    alert('게시물 요청 실패!')
                    this.$router.push()
                })   
    },
    methods: {
        ...mapActions(['fetchPhotoBoard'])
    }
}
</script>
