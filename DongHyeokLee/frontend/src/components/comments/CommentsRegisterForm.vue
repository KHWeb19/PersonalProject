<template>
    <div>
        <form @submit.prevent="onSubmit">
        <table>
        <tr>
            <td>
                 <input type="text" v-model="writer"/>
            </td>
            <td>
                <input type="text" v-model="content" placeholder="댓글을 입력하세요" />
            </td>
        </tr>
        </table>
    
        <div>
            <button type="submit">등록</button>
        </div>
        </form>
    </div>
</template>

<script>
export default {
    
    
  methods: {

        onSubmit () {
            this.boardNo = this.$store.state.freeBoard.boardNo
            const {writer, content } = this
            this.$emit('submit', { writer, content })
        }
    }
}
</script>