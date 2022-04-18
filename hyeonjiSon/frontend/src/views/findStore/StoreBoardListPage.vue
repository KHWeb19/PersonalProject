<template>
<div>

    <look-business-member-form :businessMembers="businessMembers"/>

</div>    
</template>

<script>

import LookBusinessMemberForm from '@/components/findStore/LookBusinessMemberForm.vue'

export default {
    name: 'storeBoardListPage',
    components:{
        LookBusinessMemberForm
    }, 

}
</script>

<style scoped>
.td {
  margin: 20px;
}
.btn-cover {
  margin-top: 1.5rem;
  text-align: center;
}
.btn-cover .page-btn {
  width: 5rem;
  height: 2rem;
  letter-spacing: 0.5px;
}
.btn-cover .page-count {
  padding: 0 1rem;
}
</style>