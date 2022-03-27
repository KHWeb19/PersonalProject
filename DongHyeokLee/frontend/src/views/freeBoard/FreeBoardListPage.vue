<template>
    <div id="freeBoard">
        <h2>자유게시판</h2>
        <free-board-list :freeboards="freeboards"/>
        
    </div>
</template>

<script>
export default {
    name: 'FreeBoardListPage',
    components: {
        
    }

}
</script>

<style scoped>

h2 {
    text-align: center;
    padding: 15px;
}
    
</style>