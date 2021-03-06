package com.cryptoapis.blockchains.ethereum.services;

import com.cryptoapis.common_models.ApiResponse;
import com.cryptoapis.utils.enums.HttpsRequestsEnum;
import com.cryptoapis.abstractServices.AbstractServicesConfig;
import com.cryptoapis.utils.config.EndpointConfig;
import com.cryptoapis.utils.constants.CryptoApisConstants;
import com.cryptoapis.utils.rest.WebServices;

public class EthBlockService extends AbstractServicesConfig {
    private static final String PATH = "/{0}/bc/{1}/{2}/blocks/{3}";


    public EthBlockService(EndpointConfig endpointConfig) {
        super(endpointConfig);
    }

    @Override
    protected String getPath() {
        return PATH;
    }

    public ApiResponse getBlock(String blockHash) {
        return fetchBlock(blockHash);
    }

    public ApiResponse getBlock(int blockNumber) {
        return fetchBlock(String.format("%s", blockNumber));
    }

    public ApiResponse getLatestBlock() {
        return fetchBlock(CryptoApisConstants.LATEST);
    }

    private ApiResponse fetchBlock(String endpoint) {
       return WebServices.httpsRequest(WebServices.formatUrl(url, endpointConfig, endpoint), HttpsRequestsEnum.GET.name(), endpointConfig, null);
    }
}
