 @Override
    public Set<Long> searchTradeCenter(String searchText) {
        SearchSession session = Search.session(entityManager);
        SearchScope<TraderCenterProductSKU> scope = session.scope(TraderCenterProductSKU.class);
        BooleanPredicateClausesStep<?> bool = scope.predicate().bool();
        if(searchText!=null){
            bool.must(scope.predicate().match().fields("genericProductVarietyName","genericProductName").matching(searchText));
        }
        AggregationKey<Map<String, Long>> countByProductCode = AggregationKey.of( "genericProductCode" );
        AggregationKey<Map<String, Long>> countByProductVarietyCode = AggregationKey.of( "genericProductVarietyCode" );

        SearchResult<TraderCenterProductSKU> result =
                session.search(TraderCenterProductSKU.class)
                        .where(bool.toPredicate())
                        .aggregation(countByProductCode,
                                f->f.terms()
                                        .field("genericProductCode",String.class))
                        .aggregation(countByProductVarietyCode,
                                f->f.terms()
                                        .field("genericProductVarietyCode",String.class))
                        .fetchAll();
        SearchResultTotal total = result.total();
        Map<String, Long> countOfProduct = result.aggregation( countByProductCode );
        Map<String, Long> countOfProductVariety = result.aggregation( countByProductVarietyCode );
        List<TraderCenterProductSKU> hits = result.hits();

//
       

        return null;
    }
