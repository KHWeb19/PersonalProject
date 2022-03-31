<template>
<div align: right>
    <v-list-item-action>
        <v-icon>
            mdi-group_add
        </v-icon>
    </v-list-item-action>
    <v-list-item-action>
      <v-list-item-title @click="category">회원가입</v-list-item-title>
    </v-list-item-action>

    <v-list-item-action>
        <v-icon>
            mdi-assignment-ind
        </v-icon>
    </v-list-item-action>
    <v-list-item-action>
      <v-list-item-title @click="category">마이페이지</v-list-item-title>
    </v-list-item-action>
  </div>
</template>

<script>
export default {
    
}
</script>